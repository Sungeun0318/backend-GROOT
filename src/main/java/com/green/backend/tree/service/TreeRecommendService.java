package com.green.backend.tree.service;

import com.green.backend.carbon.dto.WeatherDTO;
import com.green.backend.carbon.service.WeatherApiService;
import com.green.backend.tree.dto.SoilDTO;
import com.green.backend.tree.dto.TreeRecommendRequestDTO;
import com.green.backend.tree.dto.TreeRecommendResponseDTO;
import com.green.backend.tree.dto.TreeRecommendResponseDTO.RecommendedTree;
import com.green.backend.tree.entity.TreeCoefficient;
import com.green.backend.tree.repository.TreeCoefficientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TreeRecommendService {

    private final TreeCoefficientRepository treeCoefficientRepository;
    private final SoilApiService soilApiService;
    private final WeatherApiService weatherApiService;

    // 점수 가중치 (총 100점)
    private static final double W_SOIL = 30.0;
    private static final double W_CARBON = 35.0;
    private static final double W_WEATHER = 20.0;
    private static final double W_AREA = 15.0;

    public TreeRecommendResponseDTO recommend(TreeRecommendRequestDTO request) {
        // 1. 토양 API 호출
        SoilDTO soil = soilApiService.getSoilData(request.getPnuCode());

        // 2. 기상청 API 호출
        WeatherDTO weather = null;
        if (request.getRegionName() != null) {
            try {
                weather = weatherApiService.getCurrentWeather(request.getRegionName());
            } catch (Exception e) {
                log.warn("기상청 API 호출 실패: {}", e.getMessage());
            }
        }

        // 3. 22종 전체 조회
        List<TreeCoefficient> allSpecies = treeCoefficientRepository.findAll();

        // 4. 탄소흡수량 캐싱 + 최대/최소 (정규화용)
        Map<Integer, Double> carbonCache = allSpecies.stream()
                .collect(Collectors.toMap(TreeCoefficient::getCoefficientId, this::estimateAnnualCarbon));

        double maxCarbon = carbonCache.values().stream().mapToDouble(Double::doubleValue).max().orElse(1);
        double minCarbon = carbonCache.values().stream().mapToDouble(Double::doubleValue).min().orElse(0);
//        ===== 수정 전 코드 트러블 슈팅 용 =====
//        정규화용 최대/최소 계산 → 22종 × 2번 호출
//        double maxCarbon = allSpecies.stream().mapToDouble(this::estimateAnnualCarbon).max().orElse(1);
//        double minCarbon = allSpecies.stream().mapToDouble(this::estimateAnnualCarbon).min().orElse(0);

//        5. 각 수종별 점수 계산
//        List<RecommendedTree> scored = new ArrayList<>();
//        for (TreeCoefficient coeff : allSpecies) {
//            double carbonScore = calcCarbonScore(coeff, minCarbon, maxCarbon);  // 내부에서 또 호출
//            double carbonPerYear = estimateAnnualCarbon(coeff);                 // 또 호출
//            sb.append(String.format("%.1fkg/그루.", estimateAnnualCarbon(coeff))); // buildReason에서 또 호출
//        }

//         ====== 수정 후 코드 트러블 슈팅 용 =====
//        Map<Long, Double> carbonCache = allSpecies.stream()
//                .collect(Collectors.toMap(TreeCoefficient::getId, this::estimateAnnualCarbon));
//
//        double maxCarbon = carbonCache.values().stream().mapToDouble(Double::doubleValue).max().orElse(1);
//        double minCarbon = carbonCache.values().stream().mapToDouble(Double::doubleValue).min().orElse(0);
//
//        for (TreeCoefficient coeff : allSpecies) {
//            double carbon = carbonCache.get(coeff.getId());  // 캐시에서 꺼내기
//            double carbonScore = W_CARBON * (carbon - minCarbon) / (maxCarbon - minCarbon);
//            double carbonPerYear = carbon * soilFactor * weatherFactor;
//        }


        // 5. 각 수종별 점수 계산
        List<RecommendedTree> scored = new ArrayList<>();
        for (TreeCoefficient coeff : allSpecies) {
            double cachedCarbon = carbonCache.get(coeff.getCoefficientId());

            double soilScore = calcSoilScore(coeff, soil);
            double carbonScore = calcCarbonScoreFromCache(cachedCarbon, minCarbon, maxCarbon);
            double weatherScore = calcWeatherScore(coeff, weather);
            double areaScore = calcAreaScore(coeff, request.getArea(), request.getQuantity());

            double totalScore = soilScore + carbonScore + weatherScore + areaScore;

            // 보정된 탄소흡수량 = 기본흡수량 × 토양보정(0~1) × 날씨보정(0~1)
            double soilFactor = soilScore / W_SOIL;
            double weatherFactor = weatherScore / W_WEATHER;
            double carbonPerYear = cachedCarbon * soilFactor * weatherFactor;

            scored.add(RecommendedTree.builder()
                    .treeType(coeff.getTreeType())
                    .scientificName(coeff.getScientificName())
                    .category(coeff.getCategory())
                    .totalScore(round(totalScore))
                    .soilScore(round(soilScore))
                    .carbonScore(round(carbonScore))
                    .weatherScore(round(weatherScore))
                    .areaScore(round(areaScore))
                    .estimatedCarbonPerYear(round(carbonPerYear))
                    .estimatedTotalCarbon(round(carbonPerYear * request.getQuantity()))
                    .spacingMeter(coeff.getSpacingMeter())
                    .reason(buildReason(coeff, soil, weather, cachedCarbon))
                    .build());
        }

        // 6. 상위 3종
        scored.sort(Comparator.comparingDouble(RecommendedTree::getTotalScore).reversed());
        List<RecommendedTree> top3 = scored.subList(0, Math.min(3, scored.size()));

        double minSpacing = top3.stream().mapToDouble(RecommendedTree::getSpacingMeter).min().orElse(3.0);
        int maxTrees = (int) (request.getArea() / (minSpacing * minSpacing));

        return TreeRecommendResponseDTO.builder()
                .soilInfo(soil)
                .maxTreesByArea(maxTrees)
                .recommendations(top3)
                .build();
    }

    // ==================== 1. 토양적합도 (30점) ====================

    private double calcSoilScore(TreeCoefficient coeff, SoilDTO soil) {
        double score = 0;
        score += rangeMatchScore(soil.getDrainageGrade(), coeff.getPreferredDrainageMin(), coeff.getPreferredDrainageMax(), 10.0);
        score += rangeMatchScore(soil.getEffectiveDepth(), coeff.getPreferredDepthMin(), coeff.getPreferredDepthMax(), 8.0);
        score += rangeMatchScore(soil.getSurfaceTexture(), coeff.getPreferredTextureMin(), coeff.getPreferredTextureMax(), 6.0);
        if (soil.getGravelContent() != null) {
            score += Math.max(0, 2.0 - (soil.getGravelContent() - 1) * 0.67);
        } else {
            score += 1.0;
        }
        if (soil.getErosionGrade() != null) {
            score += Math.max(0, 2.0 - (soil.getErosionGrade() - 1) * 0.67);
        } else {
            score += 1.0;
        }
        if (soil.getForestSuitability() != null) {
            score += Math.max(0, 2.0 - (soil.getForestSuitability() - 1));
        } else {
            score += 1.0;
        }
        return score;
    }

    private double rangeMatchScore(Integer actual, Integer prefMin, Integer prefMax, double maxScore) {
        if (actual == null || prefMin == null || prefMax == null) return maxScore * 0.5;
        if (actual >= prefMin && actual <= prefMax) return maxScore;
        int distance = Math.min(Math.abs(actual - prefMin), Math.abs(actual - prefMax));
        return Math.max(0, maxScore - distance * (maxScore / 3.0));
    }

    // ==================== 2. 탄소흡수력 (35점) ====================

    private double estimateAnnualCarbon(TreeCoefficient coeff) {
        double dbh = 6.0;
        double nextDbh = dbh + coeff.getAnnualGrowth();

        double currentW = coeff.getFactorA() * Math.pow(dbh, coeff.getFactorB());
        double nextW = coeff.getFactorA() * Math.pow(nextDbh, coeff.getFactorB());

        double bef = coeff.getBef() != null ? coeff.getBef() : 1.3;
        double r = coeff.getRootRatio();

        double currentTotal = currentW * bef * (1 + r);
        double nextTotal = nextW * bef * (1 + r);

        return (nextTotal - currentTotal) * 0.5 * (44.0 / 12.0);
    }

    private double calcCarbonScoreFromCache(double carbon, double minCarbon, double maxCarbon) {
        if (maxCarbon == minCarbon) return W_CARBON * 0.5;
        return W_CARBON * (carbon - minCarbon) / (maxCarbon - minCarbon);
    }

    // ==================== 3. 날씨적합도 (20점) ====================

    private double calcWeatherScore(TreeCoefficient coeff, WeatherDTO weather) {
        if (weather == null) return W_WEATHER * 0.5;

        double score = 0;
        String category = coeff.getCategory();
        double temp = weather.getTemperature();
        int humidity = weather.getHumidity();

        // 기온 적합도 (12점)
        score += calcTempScore(temp, category);

        // 습도 적합도 (8점)
        score += calcHumidityScore(humidity, category);

        return score;
    }

    private double calcTempScore(double temp, String category) {
        double optMin, optMax, tolMin, tolMax;
        switch (category) {
            case "침엽수" -> {
                optMin = 10;
                optMax = 20;
                tolMin = -10;
                tolMax = 30;
            }
            case "상록활엽수" -> {
                optMin = 18;
                optMax = 28;
                tolMin = 5;
                tolMax = 35;
            }
            default -> {
                optMin = 15;
                optMax = 25;
                tolMin = -5;
                tolMax = 35;
            }
        }
        if (temp >= optMin && temp <= optMax) return 12.0;
        if (temp < tolMin || temp > tolMax) return 0;
        double distance = temp < optMin
                ? (optMin - temp) / (optMin - tolMin)
                : (temp - optMax) / (tolMax - optMax);
        return 12.0 * (1 - distance);
    }

    private double calcHumidityScore(int humidity, String category) {
        return switch (category) {
            case "침엽수" -> {
                // 건조에 강함: 낮은 습도 유리
                if (humidity < 50) yield 8.0;
                if (humidity < 70) yield 6.0;
                yield 4.0;
            }
            case "상록활엽수" -> {
                // 습윤 선호: 높은 습도 유리
                if (humidity >= 70) yield 8.0;
                if (humidity >= 50) yield 6.0;
                yield 3.0;
            }
            default -> {
                // 낙엽활엽수: 중간 습도 최적
                if (humidity >= 50 && humidity <= 80) yield 8.0;
                if (humidity >= 40 && humidity <= 90) yield 6.0;
                yield 3.0;
            }
        };
    }

    // ==================== 4. 면적적합도 (15점) ====================

    private double calcAreaScore(TreeCoefficient coeff, double area, int quantity) {
        int maxTrees = (int) (area / (coeff.getSpacingMeter() * coeff.getSpacingMeter()));
        if (maxTrees == 0) return 0;

        if (quantity <= maxTrees) {
            double ratio = (double) quantity / maxTrees;
            if (ratio >= 0.3 && ratio <= 0.8) return W_AREA;
            if (ratio < 0.3) return W_AREA * 0.7;
            return W_AREA * 0.8;
        } else {
            return W_AREA * Math.max(0, (double) maxTrees / quantity);
        }
    }

    // ==================== 추천 사유 ====================

    private String buildReason(TreeCoefficient coeff, SoilDTO soil, WeatherDTO weather, double cachedCarbon) {
        StringBuilder sb = new StringBuilder();

        if (soil.getDrainageGrade() != null && coeff.getPreferredDrainageMin() != null
                && soil.getDrainageGrade() >= coeff.getPreferredDrainageMin()
                && soil.getDrainageGrade() <= coeff.getPreferredDrainageMax()) {
            sb.append("배수조건 적합. ");
        }
        if (soil.getEffectiveDepth() != null && coeff.getPreferredDepthMin() != null
                && soil.getEffectiveDepth() >= coeff.getPreferredDepthMin()
                && soil.getEffectiveDepth() <= coeff.getPreferredDepthMax()) {
            sb.append("토심 적합. ");
        }
        if (weather != null) {
            double temp = weather.getTemperature();
            if ("침엽수".equals(coeff.getCategory()) && temp <= 20) sb.append("한랭 기후 적합. ");
            else if ("상록활엽수".equals(coeff.getCategory()) && temp >= 18) sb.append("온난 기후 적합. ");
            else if (temp >= 15 && temp <= 25) sb.append("기온 최적 구간. ");
        }
        sb.append(String.format("예상 연간 흡수량 %.1fkg/그루.", cachedCarbon));
        return sb.toString();
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}

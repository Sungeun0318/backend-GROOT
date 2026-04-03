package com.green.backend.carbon.service;

import com.green.backend.carbon.dto.WeatherDTO;
import com.green.backend.carbon.dto.YearlyPredictionDTO;
import com.green.backend.tree.entity.TreeCoefficient;
import com.green.backend.tree.repository.TreeCoefficientRepository;
import com.green.backend.expertreport.entity.ExpertReport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class CarbonCalculator {

    private final TreeCoefficientRepository treeCoefficientRepository;

    // ==================== 계수 조회 ====================

    /*
      수종명으로 직접 계수 조회 (22종 개별 매칭)
     */
    public TreeCoefficient getCoefficient(String treeName) {
        return treeCoefficientRepository.findByTreeType(treeName)
                .orElseThrow(() -> new IllegalArgumentException("계수 없음: " + treeName));
    }

    // ==================== 현재 CO₂ 저장량 ====================

    /*
      개별 나무의 현재 CO₂ 저장량 (kg)
      공식: factorA × (DBH² × H)^factorB × (1+rootRatio) × (44/12)
     */
    public double calculateCurrentCo2(ExpertReport report) {
        TreeCoefficient coeff = getCoefficient(report.getTreeType());
        return calculateCo2(report.getDbh(), report.getHeight(), coeff);
    }

    private double calculateCo2(double dbh, double height, TreeCoefficient coeff) {
        double biomass = coeff.getFactorA() * Math.pow(dbh * dbh * height, coeff.getFactorB());
        double totalBiomass = biomass * (1 + coeff.getRootRatio());
        // woodDensity가 있으면 적용
        if (coeff.getWoodDensity() != null && coeff.getWoodDensity() > 0) {
            totalBiomass *= coeff.getWoodDensity();
        }
        return Math.round(totalBiomass * (44.0 / 12.0) * 100.0) / 100.0;
    }

    // ==================== 수령 추정 ====================


     // DBH와 연평균 성장률로 수령 추정: age = DBH / annualGrowth

    public int estimateAge(ExpertReport report) {
        TreeCoefficient coeff = getCoefficient(report.getTreeType());
        if (coeff.getAnnualGrowth() <= 0) return 0;
        return (int) Math.round(report.getDbh() / coeff.getAnnualGrowth());
    }

    // ==================== 연간 흡수량 ====================


     // 연간 CO₂ 흡수량 (kg) = 내년 저장량 - 현재 저장량

    public double calculateAnnualAbsorption(ExpertReport report) {
        TreeCoefficient coeff = getCoefficient(report.getTreeType());
        int age = estimateAge(report);
        double ageFactor = getAgeGrowthFactor(age);

        double currentCo2 = calculateCo2(report.getDbh(), report.getHeight(), coeff);

        double nextDbh = report.getDbh() + coeff.getAnnualGrowth() * ageFactor;
        double nextHeight = report.getHeight() + (coeff.getAnnualGrowth() * 0.5) * ageFactor; // 수고는 DBH 성장의 약 50%
        double nextCo2 = calculateCo2(nextDbh, nextHeight, coeff);

        return Math.round((nextCo2 - currentCo2) * 100.0) / 100.0;
    }

    // ==================== 년별 예측 (나무 나이 + 날씨 1년 보정) ====================

    /*
     * 년별 장기 예측 (DBH 성장 + 수령 보정 + 날씨 1년 보정) -> 논문 기반
     * - 날씨 보정: 12개월 계절/기온 보정을 합산하여 연간 보정계수 산출
     */
    public List<YearlyPredictionDTO> predictYearly(ExpertReport report, int years, WeatherDTO weather) {
        TreeCoefficient coeff = getCoefficient(report.getTreeType());
        String treeType = "침엽수".equals(coeff.getCategory()) ? "CONIFER" : "BROADLEAF";
        int currentAge = estimateAge(report);

        // 1년 날씨 보정계수 산출 (12개월 계절+기온 보정 평균)
        double weatherFactor = calculateAnnualWeatherFactor(treeType, weather);

        double dbh = report.getDbh();
        double height = report.getHeight();
        int currentYear = LocalDate.now().getYear();

        List<YearlyPredictionDTO> predictions = new ArrayList<>();

        double currentCo2 = calculateCo2(dbh, height, coeff);
        predictions.add(YearlyPredictionDTO.builder()
                .year(currentYear)
                .co2Total(currentCo2)
                .co2Absorbed(0)
                .estimatedDbh(dbh)
                .estimatedHeight(height)
                .build());

        for (int i = 1; i <= years; i++) {
            int age = currentAge + i;
            double ageFactor = getAgeGrowthFactor(age);
            double prevCo2 = calculateCo2(dbh, height, coeff);

            dbh += coeff.getAnnualGrowth() * ageFactor;
            height += (coeff.getAnnualGrowth() * 0.5) * ageFactor;
            double newCo2 = calculateCo2(dbh, height, coeff);

            // 날씨 보정 적용 (연간 흡수량에 보정)
            double absorbed = (newCo2 - prevCo2) * weatherFactor;

            predictions.add(YearlyPredictionDTO.builder()
                    .year(currentYear + i)
                    .co2Total(Math.round((prevCo2 + absorbed) * 100.0) / 100.0)
                    .co2Absorbed(Math.round(absorbed * 100.0) / 100.0)
                    .estimatedDbh(Math.round(dbh * 100.0) / 100.0)
                    .estimatedHeight(Math.round(height * 100.0) / 100.0)
                    .build());
        }
        return predictions;
    }

    /*
     * 1년 날씨 보정계수: 12개월 계절보정 × 기온보정의 평균
     */
    private double calculateAnnualWeatherFactor(String treeType, WeatherDTO weather) {
        double total = 0;
        for (int month = 1; month <= 12; month++) {
            double seasonFactor = getSeasonFactor(month, treeType);
            double tempFactor = getTemperatureFactor(weather, month);
            total += seasonFactor * tempFactor;
        }
        return total / 12.0;
    }

    // ==================== 보정 계수 ====================

    /* 수령 구간별 성장 보정계수 */
    private double getAgeGrowthFactor(int age) {
        if (age <= 10) return 0.7;
        if (age <= 30) return 1.0;
        if (age <= 50) return 0.8;
        return 0.5;
    }

    /* 계절별 보정계수 */
    private double getSeasonFactor(int month, String treeType) {
        boolean isConifer = "CONIFER".equals(treeType);
        return switch (month) {
            case 3, 4, 5 -> 1;
            case 6, 7, 8 -> 1.3;
            case 9, 10, 11 -> 0.8;
            case 12, 1, 2 -> isConifer ? 0.2 : 0.05;
            default -> 1.0;
        };
    }

    /* 기온 기반 광합성 효율 보정 */
    private double getTemperatureFactor(WeatherDTO weather, int targetMonth) {
        double temp = estimateMonthlyTemp(weather, targetMonth);
        if (temp < 5) return 0.1;
        if (temp < 15) return 0.6;
        if (temp <= 25) return 1.0;
        if (temp <= 35) return 0.8;
        return 0.5;
    }

    /* 월별 평균 기온 추정 */
    private double estimateMonthlyTemp(WeatherDTO weather, int targetMonth) {
        double[] avgTemp = {-2, 0, 5, 12, 18, 23, 26, 27, 22, 15, 7, 0};
        if (weather == null) return avgTemp[targetMonth - 1];

        int currentMonth = LocalDate.now().getMonthValue();
        double diff = weather.getTemperature() - avgTemp[currentMonth - 1];
        return avgTemp[targetMonth - 1] + diff * 0.5;
    }

    /* 월 → 계절명 */
    private String getSeason(int month) {
        return switch (month) {
            case 3, 4, 5 -> "봄";
            case 6, 7, 8 -> "여름";
            case 9, 10, 11 -> "가을";
            case 12, 1, 2 -> "겨울";
            default -> "";
        };
    }
}

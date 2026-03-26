package com.green.backend.carbon.service;

import com.green.backend.carbon.dto.MonthlyPredictionDTO;
import com.green.backend.carbon.dto.WeatherDTO;
import com.green.backend.carbon.dto.YearlyPredictionDTO;
import com.green.backend.carbon.entity.TreeCoefficient;
import com.green.backend.carbon.repository.TreeCoefficientRepository;
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

    // 침엽수 목록 (여기 없으면 활엽수로 판단)
    private static final List<String> CONIFERS = List.of(
            "소나무", "잣나무", "낙엽송", "편백", "삼나무",
            "구상나무", "전나무", "측백나무", "주목", "향나무",
            "메타세쿼이아", "리기다소나무", "해송", "백송", "독일가문비"
    );

    // ==================== 계수 조회 ====================

    /**
     * 수종명 → 침엽수/활엽수 판단 → 통합 계수 가져오기
     */
    public TreeCoefficient getCoefficient(String treeName) {
        String treeType = CONIFERS.contains(treeName) ? "CONIFER" : "BROADLEAF";
        return treeCoefficientRepository.findByTreeTypeAndIsDefaultTrue(treeType)
                .orElseThrow(() -> new IllegalArgumentException("통합 계수 없음: " + treeType));
    }

    // ==================== 현재 CO₂ 저장량 ====================

    /**
     * 개별 나무의 현재 CO₂ 저장량 (kg)
     * 공식: a × (DBH² × H)^b × BEF × (1+R) × CF × (44/12)
     */
    public double calculateCurrentCo2(ExpertReport report) {
        TreeCoefficient coeff = getCoefficient(report.getTreeType());
        return calculateCo2(report.getDbh(), report.getHeight(), coeff);
    }

    private double calculateCo2(double dbh, double height, TreeCoefficient coeff) {
        double biomass = coeff.getAValue() * Math.pow(dbh * dbh * height, coeff.getBValue());
        double totalBiomass = biomass * coeff.getBef() * (1 + coeff.getRootRatio());
        double carbon = totalBiomass * coeff.getCarbonFraction();
        return Math.round(carbon * (44.0 / 12.0) * 100.0) / 100.0;
    }

    // ==================== 수령 추정 ====================

    /**
     * DBH로 수령 추정: age = c × DBH^d
     */
    public int estimateAge(ExpertReport report) {
        TreeCoefficient coeff = getCoefficient(report.getTreeType());
        return (int) Math.round(coeff.getAgeCValue() * Math.pow(report.getDbh(), coeff.getAgeDValue()));
    }

    // ==================== 연간 흡수량 ====================

    /**
     * 연간 CO₂ 흡수량 (kg) = 내년 저장량 - 현재 저장량
     */
    public double calculateAnnualAbsorption(ExpertReport report) {
        TreeCoefficient coeff = getCoefficient(report.getTreeType());
        int age = estimateAge(report);
        double ageFactor = getAgeGrowthFactor(age);

        double currentCo2 = calculateCo2(report.getDbh(), report.getHeight(), coeff);

        double nextDbh = report.getDbh() + coeff.getDbhGrowth() * ageFactor;
        double nextHeight = report.getHeight() + coeff.getHeightGrowth() * ageFactor;
        double nextCo2 = calculateCo2(nextDbh, nextHeight, coeff);

        return Math.round((nextCo2 - currentCo2) * 100.0) / 100.0;
    }

    // ==================== 월별 예측 (12개월) ====================

    /**
     * 탭1: 월별 흡수량 예측 (계절보정 + 기온보정)
     */
    public List<MonthlyPredictionDTO> predictMonthly(ExpertReport report, WeatherDTO currentWeather) {
        double annualAbsorption = calculateAnnualAbsorption(report);
        String treeType = CONIFERS.contains(report.getTreeType()) ? "CONIFER" : "BROADLEAF";
        List<MonthlyPredictionDTO> predictions = new ArrayList<>();
        LocalDate now = LocalDate.now();

        for (int i = 0; i < 12; i++) {
            LocalDate targetMonth = now.plusMonths(i);
            int month = targetMonth.getMonthValue();

            double seasonFactor = getSeasonFactor(month, treeType);
            double tempFactor = getTemperatureFactor(currentWeather, month);
            double monthlyAbsorption = (annualAbsorption / 12.0) * seasonFactor * tempFactor;

            predictions.add(MonthlyPredictionDTO.builder()
                    .month(targetMonth.getYear() + "-" + String.format("%02d", month))
                    .season(getSeason(month))
                    .co2Absorption(Math.round(monthlyAbsorption * 100.0) / 100.0)
                    .temperatureAvg(estimateMonthlyTemp(currentWeather, month))
                    .build());
        }
        return predictions;
    }

    // ==================== 10년 예측 ====================

    /**
     * 탭2: 10년 장기 예측 (DBH 성장 + 수령 보정)
     */
    public List<YearlyPredictionDTO> predictYearly(ExpertReport report, int years) {
        TreeCoefficient coeff = getCoefficient(report.getTreeType());
        int currentAge = estimateAge(report);

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

            dbh += coeff.getDbhGrowth() * ageFactor;
            height += coeff.getHeightGrowth() * ageFactor;
            double newCo2 = calculateCo2(dbh, height, coeff);

            predictions.add(YearlyPredictionDTO.builder()
                    .year(currentYear + i)
                    .co2Total(Math.round(newCo2 * 100.0) / 100.0)
                    .co2Absorbed(Math.round((newCo2 - prevCo2) * 100.0) / 100.0)
                    .estimatedDbh(Math.round(dbh * 100.0) / 100.0)
                    .estimatedHeight(Math.round(height * 100.0) / 100.0)
                    .build());
        }
        return predictions;
    }

    // ==================== 보정 계수 ====================

    /** 수령 구간별 성장 보정계수 */
    private double getAgeGrowthFactor(int age) {
        if (age <= 10) return 0.7;
        if (age <= 30) return 1.0;
        if (age <= 50) return 0.8;
        return 0.5;
    }

    /** 계절별 보정계수 */
    private double getSeasonFactor(int month, String treeType) {
        boolean isConifer = "CONIFER".equals(treeType);
        return switch (month) {
            case 3, 4, 5 -> 1.0;
            case 6, 7, 8 -> 1.3;
            case 9, 10, 11 -> 0.8;
            case 12, 1, 2 -> isConifer ? 0.2 : 0.05;
            default -> 1.0;
        };
    }

    /** 기온 기반 광합성 효율 보정 */
    private double getTemperatureFactor(WeatherDTO weather, int targetMonth) {
        double temp = estimateMonthlyTemp(weather, targetMonth);
        if (temp < 5) return 0.1;
        if (temp < 15) return 0.6;
        if (temp <= 25) return 1.0;
        if (temp <= 35) return 0.8;
        return 0.5;
    }

    /** 월별 평균 기온 추정 */
    private double estimateMonthlyTemp(WeatherDTO weather, int targetMonth) {
        double[] avgTemp = {-2, 0, 5, 12, 18, 23, 26, 27, 22, 15, 7, 0};
        if (weather == null) return avgTemp[targetMonth - 1];

        int currentMonth = LocalDate.now().getMonthValue();
        double diff = weather.getTemperature() - avgTemp[currentMonth - 1];
        return avgTemp[targetMonth - 1] + diff * 0.5;
    }

    /** 월 → 계절명 */
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

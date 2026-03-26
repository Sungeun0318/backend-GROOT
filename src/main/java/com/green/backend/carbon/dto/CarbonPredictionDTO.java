package com.green.backend.carbon.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarbonPredictionDTO {

    // 현재 상태
    private double currentCo2;              // 현재 총 CO₂ 저장량 (kg)
    private double annualAbsorption;        // 연간 CO₂ 흡수량 (kg)
    private int totalTreeCount;             // 총 나무 수

    // 탭1: 월별 예측 (12개월)
    private List<MonthlyPredictionDTO> monthlyPredictions;

    // 탭2: 10년 예측
    private List<YearlyPredictionDTO> yearlyPredictions;
}

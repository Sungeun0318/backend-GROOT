package com.green.backend.carbon.dto;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class YearlyPredictionDTO {

    private int year;               // 2026, 2027 등등
    private double co2Total;        // 해당 연도 총 CO₂ 저장량 (kg)
    private double co2Absorbed;     // 해당 연도 흡수량 (kg)
    private double estimatedDbh;    // 예측 DBH (cm)
    private double estimatedHeight; // 예측 수고 (m)
}

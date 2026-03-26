package com.green.backend.carbon.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MonthlyPredictionDTO {

    private String month;           // "2026-04"
    private String season;          // 봄, 여름, 가을, 겨울
    private double co2Absorption;   // 해당 월 흡수량 (kg)
    private double temperatureAvg;  // 평균 기온 (기상청 보정용)
}

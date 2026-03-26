package com.green.backend.carbon.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarbonStatsDTO {

    private Long memberId;
    private String companyName;
    private int totalTreeCount;          // 총 나무 수
    private double currentCo2;           // 현재 CO₂ 저장량 (kg)
    private double annualAbsorption;     // 연간 흡수량 (kg)
    private int averageAge;              // 평균 수령
}

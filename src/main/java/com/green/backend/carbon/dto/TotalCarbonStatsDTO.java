package com.green.backend.carbon.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TotalCarbonStatsDTO {

    private int totalCompanyCount;         // 총 참여 기업 수
    private int totalTreeCount;            // 전체 나무 수
    private double totalCo2Stored;         // 전체 CO2 저장량 (kg)
    private double totalAnnualAbsorption;  // 전체 연간 흡수량 (kg)
    private double averageCo2PerCompany;   // 기업당 평균 CO2 저장량 (kg)
}

package com.green.backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportDTO {

    private Long id;
    private String companyName;
    private Integer registeredTrees;
    private Double totalCarbonAbsorption;
    private String certificationLevel;
    private String monthlyCarbonData;
}

package com.green.backend.carbon.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MonthlyAbsorptionDTO {
    private String month;
    private double value;
}

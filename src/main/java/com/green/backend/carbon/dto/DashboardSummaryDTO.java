package com.green.backend.carbon.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DashboardSummaryDTO {
    private int treeCount;
    private double totalAbsorption;
    private String certStatus;
    private String nextSchedule;
}

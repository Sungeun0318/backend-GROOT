package com.green.backend.report.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SurveyHistoryDTO {
    private Long detailId;
    private int times;
    private String surveyStatus;
    private String dueStartDate;
    private String dueEndDate;
}

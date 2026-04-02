package com.green.backend.report.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportDTO {
    private Long reportId;
    private Long memberId;
    private String createdAt;
}

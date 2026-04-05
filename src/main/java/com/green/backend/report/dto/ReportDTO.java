package com.green.backend.report.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportDTO {

    private Long certificationId;
    private Long partyName;
    private String issuedDate;


}

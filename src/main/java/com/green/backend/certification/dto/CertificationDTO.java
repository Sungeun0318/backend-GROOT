package com.green.backend.certification.dto;

import com.green.backend.certification.entity.Certification;
import com.green.backend.expertreport.entity.ExpertReport;
import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CertificationDTO {
    private Long certificationId;
    private Long treeId;
    private String grade;
    private double totalScore;
    private int treeCount;
    private double totalCarbonAbsorption;
    private String status;
    private LocalDateTime issuedDate;
    private LocalDateTime expireDate;

    // dto -> entity
    public Certification toEntity(ExpertReport expertReport) {
        return Certification.builder()
                .certificationId(certificationId)
                .expertReport(expertReport)
                .grade(grade)
                .totalScore(totalScore)
                .treeCount(treeCount)
                .totalCarbonAbsorption(totalCarbonAbsorption)
                .status(status != null ? status : "활성화")
                .issuedDate(issuedDate)
                .expireDate(expireDate)
                .build();
    }
}


package com.green.backend.carbon.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyLocationDTO {

    private Long memberId;                 // 회원번호
    private String companyName;            // 기업명
    private double latitude;               // 위도
    private double longitude;              // 경도
    private int treeCount;                 // 나무 수
    private double totalCo2;               // CO2 저장량 (kg)
    private String certificationGrade;     // 인증 등급 (A/B/C 등)
}

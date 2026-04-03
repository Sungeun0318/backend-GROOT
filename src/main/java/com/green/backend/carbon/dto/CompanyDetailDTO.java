package com.green.backend.carbon.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyDetailDTO {

    private Long memberId;                 // 회원번호
    private String companyName;            // 기업명
    private String businessNumber;         // 사업자등록번호
    private String address;                // 주소

    // 탄소 현황
    private int totalTreeCount;            // 총 나무 수
    private double totalCo2Stored;         // 총 CO2 저장량 (kg)
    private double annualAbsorption;       // 연간 흡수량 (kg)

    // 답사 이력
    private int surveyCount;               // 답사 횟수
    private LocalDate lastSurveyDate;  // 최근 답사일

    // 수목 기록
    private List<TreeRecordDTO> treeRecords;
}

package com.green.backend.kakaomap.dto;


import com.green.backend.expertreport.entity.ExpertReport;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class KakaomapDto {

    private Long memberId;

    // 계산값
    private String grade;   // 탄소흡수량 기준 계산 등급
    private int treeCount;  // 최신 차수 나무 수
    private double totalCarbonAbsorption;   // 최신 차수 총 탄소흡수량

    // 기본 정보
    private String companyName;
    private String partyName;
    private String address;
}

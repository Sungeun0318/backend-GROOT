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

    // 인증 테이블
    private String grade;   // 등급
    private int treeCount;  // 나무 수
    private double totalCarbonAbsorption;   // 총흡수량

    // 기업 테이블
    private String companyName; // 회사 이름

    // 회원 테이블
    private String partyName;   // 회원 담장자 이름
    private String address;   // 주소


}

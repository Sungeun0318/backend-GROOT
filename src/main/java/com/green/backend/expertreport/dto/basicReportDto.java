package com.green.backend.expertreport.dto;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class basicReportDto {


    //
    // 답사 기본 정보
    private Long detailId;  // 답사 번호
    private String content; // 신청 내용
    private LocalDate dueStartDate; // 답사 시작일
    private LocalDate dueEndDate; // 답사 종료일
    private int times;  // 차수

    // 기업 테이블
    private String companyName; // 기업명

    // 회원 테이블
    private String partyName;   //  담당자 이름
    private String address;     // 주소


}

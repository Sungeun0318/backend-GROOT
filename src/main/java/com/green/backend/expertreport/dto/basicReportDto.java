package com.green.backend.expertreport.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class basicReportDto {

    // front 맞혀서 새로 가져올 것들
    private String content; // 신청내용
    private String dueStartDate; // 답사 시작일
    private String  times;  // 차수

}

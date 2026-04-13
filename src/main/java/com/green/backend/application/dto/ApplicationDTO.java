package com.green.backend.application.dto;

import com.green.backend.application.entity.Application;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationDTO {
    private Long detailId;              // 답사번호
    private Long memberId;           // 회원번호
    private String companyName;      // 기업명
    private Long expertId;           // 전문가번호
    private String expertName;      // 전문가 이름
    private String expertEmail;     // 전문가 이메일

    private Integer times;              // 정기차수
    private String surveyStatus;        // 답사 진행 상태 (승인대기/ 답사 예정 / 답사 진행중 / 답사 완료)
    private String requestStatus;       // 답사 신청 상태 (대기 / 승인 / 반려)

    private String content;             // 신청내용
    private String opinion;             // 의견
    private String sitePicture;         // 현장사진
    private LocalDate dueStartDate;      // 답사시작일
    private LocalDate dueEndDate;      // 답사종료일

    // baseTime
    private String createDate;
    private String updateDate;

    // Dto -> Entity 변환
    public Application toEntity() {
        return Application.builder()
                .surveyStatus("승인대기") .requestStatus("대기")
                .times(times).content(content).opinion(opinion)
                .sitePicture(sitePicture).dueStartDate(dueStartDate).dueEndDate(dueEndDate)
                .build();
    }
}

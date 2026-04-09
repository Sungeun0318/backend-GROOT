package com.green.backend.application.dto;

import com.green.backend.application.entity.Application;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ApplicationDTO {
    private Long detailId;              // 답사번호
    private Long memberId;           // 기업번호
    private Long expertId;           // 전문가번호
    private String expertName;      // 전문가 이름

    private Integer times;              // 정기차수
    private String surveyStatus;        // 상태 (신청/진행중/완료)
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
                .surveyStatus("신청")
                .times(times).content(content).opinion(opinion)
                .sitePicture(sitePicture).dueStartDate(dueStartDate).dueEndDate(dueEndDate)
                .build();
    }
}

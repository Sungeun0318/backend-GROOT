package com.green.backend.application.dto;

import com.green.backend.application.entity.Application;
import com.green.backend.expert.entity.Expert;
import com.green.backend.member.entity.Member;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
@Builder @Data
public class ApplicationDTO {
    private Long detailId;              // 답사번호
    private Long memberId;           // 기업번호
    private Long expertId;           // 전문가번호

    private Integer times;              // 정기차수
    private String surveyStatus;        // 상태 (신청/진행중/완료)
    private LocalDateTime dueDate;      // 답사일
    private String content;             // 신청내용
    private String opinion;             // 의견
    // baseTime
    private String createDate;
    private String updateDate;
    // Dto -> Entity 변환
    public Application toEntity( ){
        return Application.builder()
                .surveyStatus("신청")
                .times(times) .dueDate(dueDate) .content(content) .opinion(opinion)
                .build();
    }
}

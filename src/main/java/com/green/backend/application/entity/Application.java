package com.green.backend.application.entity;

import com.green.backend.BaseTime;
import com.green.backend.application.dto.ApplicationDTO;
import com.green.backend.expert.entity.Expert;
import com.green.backend.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Application extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detailId;              // 답사번호

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member memberId;              // 회원FK

    @ManyToOne
    @JoinColumn(name = "expert_id")
    private Expert expertId;              // 전문가FK


    private int times;                  // 정기차수
    private String surveyStatus;        // 상태 (신청/진행중/완료)
    private LocalDateTime dueDate;      // 답사일
    private String content;             // 신청내용
    private String opinion;             // 의견
    // entity -> dto
    ApplicationDTO toDto(){
        return ApplicationDTO.builder()
                .times(times) .surveyStatus(surveyStatus).dueDate(dueDate).content(content) .opinion(opinion)
                .detailId(detailId) .memberId(memberId.getMember_id()) .expertId(expertId.getExpert_id())
                .build();
    }

}

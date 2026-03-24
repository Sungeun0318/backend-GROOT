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
    private Long detail_id;              // 답사번호

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member_id;              // 회원FK

    @ManyToOne
    @JoinColumn(name = "expert_id")
    private Expert expert_id;              // 전문가FK

    private String location1;           // 위도
    private String location2;           // 경도
    private int times;                  // 정기차수
    private String surveyStatus;        // 상태 (신청/진행중/완료)
    private LocalDateTime dueDate;      // 답사일
    private String content;             // 신청내용
    @Column( nullable = false )
    private String opinion;             // 의견
    // entity -> dto
    ApplicationDTO toDto(){
        return ApplicationDTO.builder()
                .location1(location1) .location2(location2) .times(times) .surveyStatus(surveyStatus).dueDate(dueDate).content(content) .opinion(opinion)
                .detail_id(detail_id) .member_id(member_id.getMember_id()) .expert_id(expert_id.getExpert_id())
                .build();
    }

}

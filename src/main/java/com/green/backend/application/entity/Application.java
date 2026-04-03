package com.green.backend.application.entity;

import com.green.backend.BaseTime;
import com.green.backend.application.dto.ApplicationDTO;
import com.green.backend.expert.entity.Expert;
import com.green.backend.expertreport.entity.ExpertReport;
import com.green.backend.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @ToString.Exclude
    private List<ExpertReport> expertReports = new ArrayList<>(); // 전문가 보고서가 이 답사를 참조함 -> 멤버 삭제 시 연쇄 삭제


    private int times;                  // 정기차수
    private String surveyStatus;        // 상태 (신청/진행중/완료)
    private String content;             // 신청내용
    private String opinion;             // 의견
    private String sitePicture;         // 현장사진
    private LocalDate dueDate;      // 답사신청일
    private LocalDate dueStartDate; // 답사시작일
    private LocalDate dueEndDate;   // 답사종료일

    // entity -> dto
    public ApplicationDTO toDto(){
        return ApplicationDTO.builder()
                .times(times) .surveyStatus(surveyStatus).content(content) .opinion(opinion)
                .detailId(detailId) .memberId(memberId.getMid()) .expertId(expertId.getExpertId())
                .sitePicture(sitePicture) .dueDate(dueDate) .dueStartDate(dueStartDate) .dueEndDate(dueEndDate)
                .build();
    }
}

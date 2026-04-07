package com.green.backend.certification.entity;

import com.green.backend.BaseTime;
import com.green.backend.certification.dto.CertificationDTO;
import com.green.backend.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Certification extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long certificationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(length = 20)
    private String grade;

    @Column(columnDefinition = "double default 0")
    private double totalScore;

    @Column(columnDefinition = "int default 0")
    private int treeCount;

    @Column(columnDefinition = "double default 0")
    private double totalCarbonAbsorption;

    @Column(length = 20, columnDefinition = "varchar(20) default '활성화'")
    private String status;

    private LocalDateTime issuedDate;

    private LocalDateTime expireDate;

    public CertificationDTO toDto() {
        return CertificationDTO.builder()
                .certificationId(certificationId)
                .memberId(member.getMid())
                .grade(grade)
                .totalScore(totalScore)
                .treeCount(treeCount)
                .totalCarbonAbsorption(totalCarbonAbsorption)
                .status(status)
                .issuedDate(issuedDate)
                .expireDate(expireDate)
                .build();
    }
}

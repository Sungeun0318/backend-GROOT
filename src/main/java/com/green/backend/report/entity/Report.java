package com.green.backend.report.entity;

import com.green.backend.BaseTime;
import com.green.backend.member.entity.Member;
import com.green.backend.report.dto.ReportDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Report extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member memberId;

    // entity -> dto
    public ReportDTO toDto() {
        return ReportDTO.builder()
                .reportId(reportId)
                .memberId(memberId.getMid())
                .createdAt(getCreateDate() != null ? getCreateDate().toString() : null)
                .build();
    }
}

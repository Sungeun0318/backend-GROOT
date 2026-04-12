package com.green.backend.schedule.entity;

import com.green.backend.BaseTime;
import com.green.backend.expert.entity.Expert;
import com.green.backend.schedule.dto.ScheduleDTO;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder @Table( name = "schedule")
public class Schedule extends BaseTime {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( nullable = false, unique = true )
    private Long visitId; // 일정번호(PK)

    @ManyToOne
    @JoinColumn( name = "expert_id", nullable = false, unique = true )
    private Expert expertId; // 전문가번호(FK)

    @Column( nullable = false, length = 10 )
    private LocalDate scheduleStart; // 일정시작일
    private LocalDate scheduleEnd; // 일정종료일
    private String scheduleState; // 전문가 상태 = 배정불가 사유

    public ScheduleDTO toDto(){
        return ScheduleDTO.builder()
                .visitId(visitId) .expertId(expertId.getExpertId()) .scheduleStart(scheduleStart) .scheduleEnd(scheduleEnd) .scheduleState(scheduleState)
                .build();
    }
}

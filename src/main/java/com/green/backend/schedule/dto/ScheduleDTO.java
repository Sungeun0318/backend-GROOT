package com.green.backend.schedule.dto;

import com.green.backend.expert.entity.Expert;
import com.green.backend.schedule.entity.Schedule;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleDTO {
    private Long visitId; // 일정번호(PK)
    private Long expertId; // 전문가번호(FK)
    private LocalDate scheduleStart; // 불가능날짜
    private LocalDate scheduleEnd; // 불가능날짜
    private String scheduleState; // 전문가 상태 = 배정불가 사유

    public Schedule toEntity(Expert expert){
        return Schedule.builder()
                .visitId(visitId) .expertId(expert) .scheduleStart(scheduleStart) .scheduleEnd(scheduleEnd).scheduleState(scheduleState)
                .build();

    }
}

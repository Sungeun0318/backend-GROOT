package com.green.backend.schedule.controller;

import com.green.backend.expert.dto.ExpertDTO;
import com.green.backend.expert.entity.Expert;
import com.green.backend.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schedule")
public class ScheduleController {
    public final ScheduleService scheduleService;
    // (1) 전문가가 불가능한 일정 등록
    @PostMapping("")
    public ResponseEntity<?> enrollSchedule( @RequestHeader("Authorization")String token, @RequestBody ExpertDTO expertDTO ){
        return ResponseEntity.ok(true);
    }
}

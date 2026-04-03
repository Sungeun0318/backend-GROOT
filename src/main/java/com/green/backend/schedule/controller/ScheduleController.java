package com.green.backend.schedule.controller;

import com.green.backend.schedule.dto.ScheduleDTO;
import com.green.backend.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schedule")
public class ScheduleController {
    public final ScheduleService scheduleService;

    // (1) 전문가가 불가능한 일정 등록
    @PostMapping("")
    public ResponseEntity<?> enrollSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        return ResponseEntity.ok(scheduleService.enrollSchedule(scheduleDTO));
    }
    // (2) 전문가 개별전체조회
    @GetMapping("/List/{expertId}")
    public ResponseEntity<?> getEnrollScheduleList(@PathVariable Long expertId){
        List<ScheduleDTO> list = scheduleService.getEnrollScheduleList(expertId);
        return ResponseEntity.ok(list);
    }
    // (3) 전문가 일정목록 전체조회(관리자가 전체 일정조회 위해)
    @GetMapping("/List")
    public ResponseEntity<?> getAllEnrollScheduleList(){
        List<ScheduleDTO> list = scheduleService.getAllEnrollScheduleList();
        return ResponseEntity.ok(list);
    }
    // (4) 전문가 상태 변경
}

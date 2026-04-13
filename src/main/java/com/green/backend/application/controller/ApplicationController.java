package com.green.backend.application.controller;

import com.green.backend.application.dto.ApplicationDTO;
import com.green.backend.application.entity.Application;
import com.green.backend.application.service.ApplicationService;
import com.green.backend.member.dto.LoginTokenDTO;
import com.green.backend.schedule.service.ScheduleService;
import com.green.backend.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
public class ApplicationController {
    private final ApplicationService applicationService;
    private final JwtUtil jwtUtil;


    // [1] 답사 신청 내역 등록
    @PostMapping("/visit")
    public ResponseEntity<?> CreateVisitRequest(@RequestHeader("Authorization") String token, @RequestBody ApplicationDTO applicationDTO) {
        LoginTokenDTO loginUser = jwtUtil.extractFromHeader(token);
        if (loginUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }
        applicationService.CreateVisitRequest(loginUser, applicationDTO);
        return ResponseEntity.ok("답사신청이 완료되었습니다.");
    }

    // [2] 답사 신청 내역 조회
    @GetMapping("/visit")
    public ResponseEntity<?> ReadVisitRequest(@RequestHeader(value = "Authorization", required = false) String token) {
        LoginTokenDTO loginUser = jwtUtil.extractFromHeader(token);
        if (loginUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }

        return ResponseEntity.ok(applicationService.ReadVisitRequest(loginUser.getMid()));
    }

}

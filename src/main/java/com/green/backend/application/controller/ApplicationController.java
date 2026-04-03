package com.green.backend.application.controller;

import com.green.backend.application.dto.ApplicationDTO;
import com.green.backend.application.entity.Application;
import com.green.backend.application.service.ApplicationService;
import com.green.backend.schedule.service.ScheduleService;
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
    private final ScheduleService scheduleService;

    // [1] 답사 신청 내역 등록
    @PostMapping("/visit")
    public ResponseEntity<?> CreateVisitRequest(@RequestHeader("Authorization")String token,@RequestBody ApplicationDTO applicationDTO){
        String jwt = token.startsWith("Bearer ") ? token.substring(7) : token; // "Bearer " 제거하여 순수 토큰 문자열만 추출
        boolean result = applicationService.CreateVisitRequest(jwt, applicationDTO); // 서비스로 토큰과 DTO 전달
        if (result) { return ResponseEntity.ok().body("답사 신청이 완료되었습니다.");
        } else { return ResponseEntity.badRequest().body("답사 신청에 실패했습니다. 유효하지 않은 회원입니다.");
        }
    }

   // [2] 답사 신청 내역 조회
   @GetMapping("/visit")
   public ResponseEntity<?> ReadVisitRequest(@RequestHeader(value = "Authorization", required = false) String token) {
       // 1. 토큰이 없거나 형식이 잘못된 경우 먼저 차단 (안전한 순서)
       if (token == null || !token.startsWith("Bearer ")) {return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요한 서비스입니다.");}
       String jwt = token.substring(7); // 2. "Bearer " 제거하여 순수 토큰만 추출
       Object result = applicationService.ReadVisitRequest(jwt);  // 3. 서비스 호출 시 'jwt' 변수를 전달 (token 대신!)
       return ResponseEntity.ok(result);
   }

   // [3]
}

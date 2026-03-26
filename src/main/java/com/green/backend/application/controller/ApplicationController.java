package com.green.backend.application.controller;

import com.green.backend.application.dto.ApplicationDTO;
import com.green.backend.application.entity.Application;
import com.green.backend.application.service.ApplicationService;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<?> ReadVisitRequest(@RequestHeader("Authorization") String token){
    if( token == null || !token.startsWith( "Bearer" ) ){return ResponseEntity.ok(false);
    } return ResponseEntity.ok(applicationService.ReadVisitRequest(token)); // 서비스 호출 후 결과를 OK로 반환
    }
}

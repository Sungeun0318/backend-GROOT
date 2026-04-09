package com.green.backend.report.controller;

import com.green.backend.member.dto.LoginTokenDTO;
import com.green.backend.member.dto.MemberResponseDTO;
import com.green.backend.report.dto.ReportPreviewDTO;
import com.green.backend.report.service.ReportService;
import com.green.backend.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:5173", allowCredentials = "true")
public class ReportController {

    private final ReportService reportService;
    private final JwtUtil jwtUtil;



    // 보고서 미리보기
    @GetMapping
    public ResponseEntity<?> preview(
            @RequestHeader("Authorization") String token,
            @RequestParam("times") int times
    ) {
        Long mid = getMidFromToken(token);
        ReportPreviewDTO previewDTO = reportService.preview(mid, times);
        return ResponseEntity.ok(previewDTO);
    }

    // mid 추춣 함수
    private Long getMidFromToken(String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            return null;
        }
        token = token.replace("Bearer ", "");
        LoginTokenDTO dto = jwtUtil.validateToken(token);
        return dto.getMid();
    }



}

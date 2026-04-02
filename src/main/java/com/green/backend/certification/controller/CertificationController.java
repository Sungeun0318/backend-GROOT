package com.green.backend.certification.controller;

import com.green.backend.certification.dto.CertStatusDTO;
import com.green.backend.certification.dto.GradeInfoDTO;
import com.green.backend.certification.service.CertificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/certifications")
public class CertificationController {

    private final CertificationService certificationService;

    // 1. 인증 현황 조회
    // http://localhost:8080/api/certifications/status/1
    @GetMapping("/status/{memberId}")
    public ResponseEntity<CertStatusDTO> getCertificationStatus(@PathVariable Long memberId) {
        return ResponseEntity.ok(certificationService.getStatus(memberId));
    }

    // 2. 등급 기준 목록
    // http://localhost:8080/api/certifications/grades
    @GetMapping("/grades")
    public ResponseEntity<List<GradeInfoDTO>> getGrades() {
        return ResponseEntity.ok(certificationService.getGrades());
    }

    // 3. PNG 인증마크 다운로드
    // http://localhost:8080/api/certifications/download/png/1
    @GetMapping("/download/png/{memberId}")
    public ResponseEntity<?> downloadPng(@PathVariable Long memberId) {
        // TODO: 인증마크 이미지 생성 및 다운로드
        return ResponseEntity.ok("PNG 다운로드 - 구현 예정");
    }

    // 4. PDF 인증서 다운로드
    // http://localhost:8080/api/certifications/download/pdf/1
    @GetMapping("/download/pdf/{memberId}")
    public ResponseEntity<?> downloadPdf(@PathVariable Long memberId) {
        // TODO: 인증서 PDF 생성 및 다운로드
        return ResponseEntity.ok("PDF 다운로드 - 구현 예정");
    }
}

package com.green.backend.controller;

import com.green.backend.dto.ReportDTO;
import com.green.backend.entity.Report;
import com.green.backend.service.ReportService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @PostMapping
    public ResponseEntity<Report> createReport(@RequestBody ReportDTO dto) {
        return ResponseEntity.ok(reportService.createReport(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Report> getReport(@PathVariable Long id) {
        return ResponseEntity.ok(reportService.getReport(id));
    }

    @PostMapping("/{id}/share")
    public ResponseEntity<Map<String, String>> generateShare(
            @PathVariable Long id, HttpServletRequest request) {
        String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        return ResponseEntity.ok(reportService.generateQrShare(id, baseUrl));
    }

    @GetMapping("/shared/{token}")
    public ResponseEntity<?> getSharedReport(@PathVariable String token) {
        Report report = reportService.getReportByToken(token);
        if (report == null) {
            return ResponseEntity.status(HttpStatus.GONE)
                    .body(Map.of("message", "만료된 링크입니다."));
        }
        return ResponseEntity.ok(report);
    }

    @PostMapping("/shared/{token}/send")
    public ResponseEntity<Map<String, String>> markAsSent(@PathVariable String token) {
        reportService.markAsSent(token);
        return ResponseEntity.ok(Map.of("message", "전송 완료. DB에 저장되었습니다."));
    }
}

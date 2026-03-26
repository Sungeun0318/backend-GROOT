package com.green.backend.application.controller;

import com.green.backend.application.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {
    private final ApplicationService applicationService;

    // [1] 모든 답사내역 목록 조회
    @GetMapping("/visits")
    public ResponseEntity<?> readAllVistRequest(){
        return ResponseEntity.ok(applicationService.readAllVisitRequests());
    }

//    // [2] 전문가 배정
//    @PutMapping("/visit/assign")
//    public ResponseEntity<?>

}

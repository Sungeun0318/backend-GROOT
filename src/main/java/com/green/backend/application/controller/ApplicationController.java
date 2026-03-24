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
//    @PostMapping("/api/visit")
//    public ResponseEntity<?> CreateVisitRequest(@RequestBody ApplicationDTO applicationDTO){
//        return ResponseEntity.ok(applicationService.CreateVisitRequest(applicationDTO));
//    }

}

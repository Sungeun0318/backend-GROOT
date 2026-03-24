package com.green.backend.expertreport.controller;


import com.green.backend.expertreport.dto.ExpertReportDTO;
import com.green.backend.expertreport.service.ExpertReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expert-reports")
@RequiredArgsConstructor
public class ExpertReportController {

    private final ExpertReportService expertReportService;

    // 답사 정보 등록
    @PostMapping
    public ResponseEntity<?> saveSurvey(@RequestBody List<ExpertReportDTO> list){
        boolean listResult = expertReportService.saveSurvey(list);

        return ResponseEntity.ok(listResult);
    }
    /*
    // 답사 정보 조회
    @GetMapping
    public ResponseEntity<?> findSurvey(@)
    */

}

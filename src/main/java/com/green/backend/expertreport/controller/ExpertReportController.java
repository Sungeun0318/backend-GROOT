package com.green.backend.expertreport.controller;


import com.green.backend.application.dto.ApplicationDTO;
import com.green.backend.expertreport.dto.ExpertReportDTO;
import com.green.backend.expertreport.service.ExpertReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@RestController
@RequestMapping("/api/expert-reports")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class ExpertReportController {

    private final ExpertReportService expertReportService;

    // 전문가 - 답사 정보 등록
    @PostMapping
    public ResponseEntity<?> saveSurvey(
            @RequestPart("data") String data,
            @RequestPart("site") MultipartFile site,
            @RequestPart("files") List<MultipartFile> files
    ) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        // JSON 문자열 -> DTO 리스트 변환
        List<ExpertReportDTO> dtoList =
                objectMapper.readValue(data, new TypeReference<List<ExpertReportDTO>>() {
                });

        boolean result = expertReportService.saveSurvey(dtoList, files, site);
        return ResponseEntity.ok(result);
    }

    // 전문가 - 답사 정보 조회

    // 완료 답사 목록 조회
    @GetMapping("/{detailId}")
    public ResponseEntity<?> getSurvey(
            @PathVariable Long detailId
    ) {
        List<ApplicationDTO> result = expertReportService.getSurvey(detailId);
        return ResponseEntity.ok(result);
    }

    // 선택한 답사신청번호의 나무 정보 + 종합의견 조회
    @GetMapping
    public ResponseEntity<?> getSurveyDetail(
            @RequestParam Long detailId
    ) {
        List<ExpertReportDTO> result = expertReportService.getSurveyDetail(detailId);
        return ResponseEntity.ok(result);
    }

    // 답사 링크 유효 조회
    @GetMapping("/link")
    public ResponseEntity<?> getLink(@RequestParam Long detailId){

        boolean result = expertReportService.getLink(detailId);
        return ResponseEntity.ok(result);
    }


}

package com.green.backend.expertreport.controller;


import com.green.backend.expertreport.dto.ExpertReportDTO;
import com.green.backend.expertreport.service.ExpertReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@RestController
@RequestMapping("/api/expert-reports")
@RequiredArgsConstructor
public class ExpertReportController {

    private final ExpertReportService expertReportService;

    // 전문가 - 답사 정보 등록
    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<?> saveSurvey(
            @RequestPart("data") String data,
            @RequestPart("files") List<MultipartFile> files
    ) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        List<ExpertReportDTO> dtoList =
                objectMapper.readValue(data, new TypeReference<List<ExpertReportDTO>>() {});
        boolean result = expertReportService.saveSurvey(dtoList, files);
        return ResponseEntity.ok(result);
    }

    // 전문가 - 답사 정보 조회
    @GetMapping
    public ResponseEntity<?> findSurvey(@RequestParam int memberId){
        boolean result = expertReportService.findSurvey(memberId);
        return ResponseEntity.ok(result);

    }


}

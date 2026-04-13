package com.green.backend.expertreport.controller;

import com.green.backend.expertreport.dto.TempSaveDto;
import com.green.backend.expertreport.service.TempSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/temp-save")
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:5173", allowCredentials = "true")
public class TempSaveController {

    private final TempSaveService tempSaveService;

    // 임시 저장
    @PostMapping
    public ResponseEntity<?> saveTemp(@RequestBody TempSaveDto dto) {
        boolean result = tempSaveService.saveTemp(dto);
        return ResponseEntity.ok(result);
    }

    // 임시 저장 조회
    @GetMapping("/{detailId}")
    public ResponseEntity<?> getTemp(@PathVariable Long detailId) {
        TempSaveDto result = tempSaveService.getTemp(detailId);
        return ResponseEntity.ok(result);
    }

    // 임시 저장 삭제
    @DeleteMapping("/{detailId}")
    public ResponseEntity<?> deleteTemp(@PathVariable Long detailId) {
        tempSaveService.deleteTemp(detailId);
        return ResponseEntity.ok(true);
    }
}
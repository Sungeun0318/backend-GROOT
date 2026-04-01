package com.green.backend.expert.controller;

import com.green.backend.expert.dto.ExpertDTO;
import com.green.backend.expert.service.ExpertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/specialist")
public class ExpertController {

    private final ExpertService expertService;

    // [1] 전문가 등록
    @PostMapping("")
    public ResponseEntity<?> createSpecialist(@RequestBody ExpertDTO expertDTO) {
        boolean result = expertService.createSpecialist(expertDTO);
        if (result) { return ResponseEntity.ok().body(true);
        } else { return ResponseEntity.badRequest().body(false);
        }
    }

    // [2] 전문가목록 전체 조회
    @GetMapping("")
    public ResponseEntity<List<ExpertDTO>> GetAllSpecialist() {
        return ResponseEntity.ok(expertService.GetAllSpecialist());
    }

    // [3] 전문가 개별 조회
    @GetMapping("/{id}")
    public ResponseEntity<?> GetSpecialist(@PathVariable("id") Long expertId) {
            try { ExpertDTO expertDTO = expertService.GetSpecialist(expertId);
                return ResponseEntity.ok(expertDTO);
            } catch (IllegalArgumentException e) {return ResponseEntity.badRequest().body(false);
            }
        }
    // [4] 전문가 수정
    @PutMapping("/{id}")
    public ResponseEntity<?> updateSpecialist(@PathVariable("id") Long expertId, @RequestBody ExpertDTO expertDTO) {
        boolean result = expertService.updateSpecialist(expertId, expertDTO);
        return result ? ResponseEntity.ok(true) : ResponseEntity.badRequest().body(false);
    }

    // [5] 전문가 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSpecialist(@PathVariable("id") Long expertId) {
        boolean result = expertService.deleteSpecialist(expertId);
        return result ? ResponseEntity.ok(true) : ResponseEntity.badRequest().body(false);
    }
}

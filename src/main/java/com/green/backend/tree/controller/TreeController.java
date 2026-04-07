package com.green.backend.tree.controller;

import com.green.backend.tree.dto.TreeRecommendRequestDTO;
import com.green.backend.tree.dto.TreeRecommendResponseDTO;
import com.green.backend.tree.service.TreeRecommendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trees")
@RequiredArgsConstructor
public class TreeController {

    private final TreeRecommendService treeRecommendService;

    /*
     * 나무 추천 API
     * 토양 API + 22종 탄소흡수량 기반 최적 2~3종 추천
     */
    @PostMapping("/recommend")
    public ResponseEntity<TreeRecommendResponseDTO> recommend(@RequestBody TreeRecommendRequestDTO request) {
        TreeRecommendResponseDTO response = treeRecommendService.recommend(request);
        return ResponseEntity.ok(response);
    }
}

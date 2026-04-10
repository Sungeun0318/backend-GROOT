package com.green.backend.kakaomap.controller;

import com.green.backend.kakaomap.service.KakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kakaomap")
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:5173", allowCredentials = "true")
public class KakaomapController {

    private final KakaoService kakaoService;

    // 기업
    @GetMapping("/{memberId}")
    public ResponseEntity<?> kakaomap(@PathVariable Long memberId) {
        return ResponseEntity.ok(kakaoService.kakaomap(memberId));
    }

    //  나무
    @GetMapping("/tree/{memberId}")
    public ResponseEntity<?> treeMap(@PathVariable Long memberId){
        return ResponseEntity.ok(kakaoService.treeMap(memberId));
    }
}
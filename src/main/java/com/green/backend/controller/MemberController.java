package com.green.backend.controller;

import com.green.backend.dto.LoginDTO;
import com.green.backend.dto.MemberDTO;
import com.green.backend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // POST /api/members/signup - 회원가입
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody MemberDTO dto) {
        // TODO: 구현
        return ResponseEntity.ok().build();
    }

    // POST /api/members/login - 로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO dto) {
        // TODO: 구현
        return ResponseEntity.ok().build();
    }

    // POST /api/members/logout - 로그아웃
    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        // TODO: 구현
        return ResponseEntity.ok().build();
    }
}

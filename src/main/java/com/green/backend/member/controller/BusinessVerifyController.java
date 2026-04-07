package com.green.backend.member.controller;

import com.green.backend.member.dto.CompanyDTO;
import com.green.backend.member.service.BusinessVerifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class BusinessVerifyController {

    private final BusinessVerifyService businessVerifyService;

    // 일단 안쓰긴함
    @PostMapping("/verify")
    public ResponseEntity<Boolean> verifyBusiness(@RequestParam String  bnumber) {
        boolean result = businessVerifyService.verifyBusiness(bnumber);
        return ResponseEntity.ok(result);
    }
}

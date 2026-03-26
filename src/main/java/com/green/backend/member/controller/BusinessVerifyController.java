package com.green.backend.member.controller;

import com.green.backend.member.dto.BusinessDto;
import com.green.backend.member.service.BusinessVerifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/business")
@RequiredArgsConstructor
public class BusinessVerifyController {

    private final BusinessVerifyService businessVerifyService;

    @PostMapping("/verify")
    public ResponseEntity<Boolean> verifyBusiness(@RequestBody BusinessDto bnumber) {
        boolean result = businessVerifyService.verifyBusiness(bnumber);
        return ResponseEntity.ok(result);
    }
}

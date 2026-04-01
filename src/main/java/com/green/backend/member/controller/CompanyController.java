package com.green.backend.member.controller;

import com.green.backend.member.dto.CompanyDTO;
import com.green.backend.member.dto.CompanyResponseDTO;
import com.green.backend.member.dto.MemberResponseDTO;
import com.green.backend.member.entity.Company;
import com.green.backend.member.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/company")
public class CompanyController {

    private final CompanyService companyService;

    // 기업 등록
    @PostMapping("/add")
    public ResponseEntity<?> companyadd(CompanyDTO companyDTO) {
        return ResponseEntity.ok(companyService.companyadd(companyDTO));
    }

    // 기업 수정
    @PutMapping("/update/{companyId}")
    public ResponseEntity<?> companyUpdate(
            @PathVariable Long companyId,
            CompanyDTO companyDTO) {
        return ResponseEntity.ok(companyService.companyUpdate(companyId, companyDTO));
    }

    // 기업 삭제
    @DeleteMapping("/delete/{companyId}")
    public ResponseEntity<?> companyDelete(@PathVariable Long companyId) {
        return ResponseEntity.ok(companyService.companyDelete(companyId));
    }

    // 기업 단건 조회
    @GetMapping("/{companyId}")
    public ResponseEntity<?> companyInfo(@PathVariable Long companyId) {
        return ResponseEntity.ok(companyService.companyInfo(companyId));
    }

    // 기업 전체 목록
    @GetMapping("/list")
    public ResponseEntity<?> companyList() {
        return ResponseEntity.ok(companyService.companyList());
    }


} // class end

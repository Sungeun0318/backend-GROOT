package com.green.backend.application.controller;

import com.green.backend.application.dto.ApplicationDTO;
import com.green.backend.application.service.ApplicationService;
import com.green.backend.member.entity.Company;
import com.green.backend.member.entity.Member;
import com.green.backend.member.repository.CompanyRepository;
import com.green.backend.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {

    private final ApplicationService applicationService;
    private final MemberRepository memberRepository;
    private final CompanyRepository companyRepository;

    // [1] 모든 답사내역 목록 조회
    @GetMapping("/visits")
    public ResponseEntity<?> readAllVistRequest(){
        return ResponseEntity.ok(applicationService.readAllVisitRequests());
    }

    // [2] 신청내역에서 전문가 배정
    @PutMapping("/visit/assign")
    public ResponseEntity<?>assignExpert(@RequestBody ApplicationDTO dto){
        return ResponseEntity.ok(applicationService.assignExpert(dto));
    }




    // ===================== 관리자가 회원에게 권한 부여 ========================
    // 기업 승인
    @PatchMapping("/company/{companyId}/approve")
    public ResponseEntity<?>approveCompany(@PathVariable Long companyId){
        Company company = companyRepository.findById(companyId).orElse(null);
        if (company==null){return ResponseEntity.ok(false);}
        company.setIsApproved(1);
        companyRepository.save(company);
        return ResponseEntity.ok(true);
    }

    // 회원 승인
    @PatchMapping("/member/{memberId}/approve")
    public ResponseEntity<?>approveMember(@PathVariable Long memberId){
        Member member = memberRepository.findById(memberId).orElse(null);
        if (member==null){return ResponseEntity.ok(false);}
        member.setIsApproved(1);
        memberRepository.save(member);
        return ResponseEntity.ok(true);
    }

    // 승인 대기 기업 목록
    @GetMapping("/company/pending")
    public ResponseEntity<?> getPendingCompanies() {
        return ResponseEntity.ok(companyRepository.findByIsApproved(0));
    }

    // 승인 대기 회원 목록
    @GetMapping("/member/pending")
    public ResponseEntity<?> getPendingMembers() {
        return ResponseEntity.ok(memberRepository.findByIsApproved(0));
    }

}

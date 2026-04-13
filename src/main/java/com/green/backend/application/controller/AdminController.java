package com.green.backend.application.controller;

import com.green.backend.application.dto.ApplicationDTO;
import com.green.backend.application.service.ApplicationService;
import com.green.backend.member.dto.CompanyResponseDTO;
import com.green.backend.member.dto.LoginTokenDTO;
import com.green.backend.member.dto.MemberResponseDTO;
import com.green.backend.member.entity.Company;
import com.green.backend.member.entity.Member;
import com.green.backend.member.repository.CompanyRepository;
import com.green.backend.member.repository.MemberRepository;
import com.green.backend.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    private final ApplicationService applicationService;
    private final MemberRepository memberRepository;
    private final CompanyRepository companyRepository;
    private final JwtUtil jwtUtil;

    // [1] 모든 답사내역 목록 조회
    @GetMapping("/visits")
    public ResponseEntity<?> readAllVisitRequests() {
        return ResponseEntity.ok(applicationService.readAllVisitRequests());
    }

    // [2] 신청내역에서 전문가 배정
    @PutMapping("/visit/assign")
    public ResponseEntity<?> assignExpert(@RequestBody ApplicationDTO dto) {
        applicationService.assignExpert(dto);
        return ResponseEntity.ok("전문가가 배정되었습니다.");
    }

    // [3] 기업의 답사신청 승인/반려(대기/승인/반려)
    @PutMapping("/visit/permission")
    public ResponseEntity<?> updateRequestStatus(@RequestBody ApplicationDTO dto) {
        // dto에 detailId + requestStatus("승인" or "반려") 만 담아서 요청
        applicationService.updateRequestStatus(dto);
        return ResponseEntity.ok("상태가 변경되었습니다.");
    }

    // ===================== 관리자가 회원에게 권한 부여 ========================
    // 기업 승인
    @PatchMapping("/company/{companyId}/approve")
    public ResponseEntity<?> approveCompany(@PathVariable Long companyId) {
        Company company = companyRepository.findById(companyId).orElse(null);
        if (company == null) {
            return ResponseEntity.ok(false);
        }
        company.setIsApproved(1);
        companyRepository.save(company);
        return ResponseEntity.ok(true);
    }

    // 회원 승인
    @PatchMapping("/member/{memberId}/approve")
    public ResponseEntity<?> approveMember(@PathVariable Long memberId) {
        Member member = memberRepository.findById(memberId).orElse(null);
        if (member == null) {
            return ResponseEntity.ok(false);
        }
        member.setIsApproved(1);
        memberRepository.save(member);
        return ResponseEntity.ok(true);
    }

    // 기업 거절
    @PatchMapping("/company/{companyId}/reject")
    public ResponseEntity<?> rejectCompany(@PathVariable Long companyId) {
        Company company = companyRepository.findById(companyId).orElse(null);
        if (company == null) {
            return ResponseEntity.ok(false);
        }
        company.setIsApproved(2);
        companyRepository.save(company);
        return ResponseEntity.ok(true);
    }

    // 회원 거절
    @PatchMapping("/member/{memberId}/reject")
    public ResponseEntity<?> rejectMember(@PathVariable Long memberId) {
        Member member = memberRepository.findById(memberId).orElse(null);
        if (member == null) {
            return ResponseEntity.ok(false);
        }
        member.setIsApproved(2);
        memberRepository.save(member);
        return ResponseEntity.ok(true);
    }

    // ===================== 승인 대기 명단  ========================
//0
    // 승인 대기 기업 목록
    @GetMapping("/company/pending")
    public ResponseEntity<?> getPendingCompanies() {

        List<Company> clist = companyRepository.findByIsApproved(0);
        List<CompanyResponseDTO> clist2 = new ArrayList<>();
        for (int i = 0; i < clist.size(); i++) {
            clist2.add(clist.get(i).toDTO());
        }

        return ResponseEntity.ok(clist2);
    }

    // 승인 대기 회원 목록
    @GetMapping("/member/pending")
    public ResponseEntity<?> getPendingMembers() {
        List<Member> mlist = memberRepository.findByIsApproved(0);

        List<MemberResponseDTO> mlist2 = new ArrayList<>();

        for (int i = 0; i < mlist.size(); i++) {
            mlist2.add(mlist.get(i).toDTO());
        }

        return ResponseEntity.ok(mlist2);
    }

}

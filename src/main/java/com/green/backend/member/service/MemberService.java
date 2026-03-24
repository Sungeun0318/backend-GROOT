//package com.green.backend.member.service;
//
//import com.green.backend.member.dto.LoginDTO;
//import com.green.backend.member.dto.MemberDTO;
//import com.green.backend.member.entity.Company;
//import com.green.backend.member.entity.Member;
//import com.green.backend.member.repository.CompanyRepository;
//import com.green.backend.member.repository.MemberRepository;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//@Transactional
//public class MemberService {
//
//    private final MemberRepository memberRepository;
//    private final CompanyRepository companyRepository;
//
//    // 회원 가입
//    public boolean signup(MemberDTO memberDTO){
//
//        // member_name으로 회원 조회 (회원아이디 중복체크 )
//        if(memberRepository.existsByMember_name(memberDTO.getMember_name()).isPresent()){
//            return false;
//        }
//
//        //email 중복 체크
//        if()
//
//        // 엔티티변환 전에 받은 기업아이디로 기업찾기
//        Company company = companyRepository.findById(memberDTO.getCompany_id())
//                .orElseThrow(()->new RuntimeException("기업 없음"));
//
//        // 받은 dto 엔티티로 변환 (기업 정보 넣어주기 )
//        Member member = memberDTO.toEntity(company);
//
//        memberRepository.save(member);
//        return null;
//    }
//
//
//
//
//
//}

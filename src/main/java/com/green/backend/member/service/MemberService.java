package com.green.backend.member.service;

import com.green.backend.member.dto.LoginDTO;
import com.green.backend.member.dto.MemberDTO;
import com.green.backend.member.entity.Member;
import com.green.backend.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberService memberService;

    // 회원 가입
    public Long signup(MemberDTO memberDTO){
        // 받은 dto 엔티티로 변환
        return null;
    }




}

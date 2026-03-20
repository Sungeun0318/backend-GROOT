package com.green.backend.service;

import com.green.backend.dto.LoginDTO;
import com.green.backend.dto.MemberDTO;
import com.green.backend.entity.Member;
import com.green.backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // TODO: 회원가입 로직 구현
    public Member signup(MemberDTO dto) {
        return null;
    }

    // TODO: 로그인 로직 구현
    public Member login(LoginDTO dto) {
        return null;
    }
}

package com.green.backend.member.service;

import com.green.backend.expertreport.service.FileService;
import com.green.backend.member.dto.LoginDTO;
import com.green.backend.member.dto.MemberDTO;
import com.green.backend.member.entity.Company;
import com.green.backend.member.entity.Member;
import com.green.backend.member.repository.CompanyRepository;
import com.green.backend.member.repository.MemberRepository;
import com.green.backend.util.JwtUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    private final CompanyRepository companyRepository;

    // [*] 비크립트(암호화) 객체 생성
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    // 파일 서비스
    private final FileService fileService;

    // 회원 가입
    public boolean signup(MemberDTO memberDTO){

        // member_name으로 회원 조회 (회원아이디 중복체크 )
        if(memberRepository.existsByMname(memberDTO.getMname())){
            return false;
        }

        //email 중복 체크
        if(memberRepository.existsByEmail(memberDTO.getEmail())){
            return false;
        }

        // 엔티티변환 전에 받은 기업아이디로 기업찾기
        Company company = companyRepository.findById(memberDTO.getCompany_id())
                .orElseThrow(()->new RuntimeException("기업 없음"));


        // 받은 dto 엔티티로 변환 (기업 정보 넣어주기 )
        Member member = memberDTO.toEntity(company);

        // ******* 최종 저장 하기 전에 입력받은 비밀번호를 암호화 ********** //
        String pwd = passwordEncoder.encode(member.getPassword());
        member.setPassword(pwd);

        // +++++++++ 최종 DB에 엔티티를 SAVE 하기 전에 첨부파일이 존재하면 업로드 +++++++++++//
        String fileName =  fileService.saveFile( memberDTO.getImage() ); // dto내 multipartFile 대입한다.
        // 만약에 업로드 했다면 저장할 엔티티에 업로드된 파일명 저장하기
        if( fileName != null ){ member.setMfile( fileName ); }

        // 저장
        Member saveMember = memberRepository.save(member);
        if (saveMember.getMid()>=1){
            return true;
        }
        return false;
    }

    // 로그인
    public Long login(LoginDTO loginDTO){
        Optional<Member>find = memberRepository.findByMname(loginDTO.getMname());
        if (find.isPresent()){
            // 엔티티 꺼내기
            Member member = find.get();
            // 비크립트 암호화로 꺼낸엔티티비번과 작성한비번 비교 (평문 , 암호문)
            boolean result = passwordEncoder.matches(loginDTO.getPassword(),member.getPassword());

            if (result){return member.getMid();}
        }
        return null;

    }

    // 회원탈퇴
    public boolean withdraw(Long mid){
        memberRepository.deleteById(mid);
        return true;
    }





}

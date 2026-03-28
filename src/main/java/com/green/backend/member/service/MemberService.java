package com.green.backend.member.service;

import com.green.backend.FileService;
import com.green.backend.member.dto.LoginDTO;
import com.green.backend.member.dto.MemberDTO;
import com.green.backend.member.dto.MemberResponseDTO;
import com.green.backend.member.dto.MemberUpdateDTO;
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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        // 프로필 사진 저장
        String profileFileName = fileService.saveFile(memberDTO.getImage());
        if (profileFileName != null) { member.setMfile(profileFileName); }

        // 경력증명서 저장
        String careerFileName = fileService.saveFile(memberDTO.getCareerPdf());
        if (careerFileName != null) { member.setCareerFile(careerFileName); }

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

    // 회원 수정
    public boolean mupdate(Long mid, MemberUpdateDTO memberUpdateDTO){

        Optional<Member>optional = memberRepository.findById(mid);

        if (optional.isPresent()){
            Member member = optional.get();

            String fileName = fileService.saveFile(memberUpdateDTO.getImage());
            if (fileName != null) { member.setMfile(fileName); }

            if (memberUpdateDTO.getPassword() != null) {
                member.setPassword(passwordEncoder.encode(memberUpdateDTO.getPassword()));
            }
            if (memberUpdateDTO.getAddress() != null) {
                member.setAddress(memberUpdateDTO.getAddress());
            }
            if (memberUpdateDTO.getParty_name() != null) {
                member.setParty_name(memberUpdateDTO.getParty_name());
            }
            if (memberUpdateDTO.getMfile() != null) {
                member.setMfile(memberUpdateDTO.getMfile());
            }
            String careerFileName = fileService.saveFile(memberUpdateDTO.getCareerPdf());
            if (careerFileName != null) { member.setCareerFile(careerFileName); }
        }
        return true;

    }

    // 마이페이지 (회원단건조회)
    public MemberResponseDTO mPrint(Long mid){

        Optional<Member>optional = memberRepository.findById(mid);

        if (optional.isPresent()){
            Member member = optional.get();
            return MemberResponseDTO.builder()
                    .mname(member.getMname())
                    .email(member.getEmail())
                    .address(member.getAddress())
                    .party_name(member.getParty_name())
                    .company_number(member.getCompany_number())
                    .mfile(member.getMfile())
                    .careerFile(member.getCareerFile())
                    .build();
        }
        return null;
    }

    // 회원 목록 조회
    public List<MemberResponseDTO> memberList() {
        return memberRepository.findAll().stream()
                .map(m -> MemberResponseDTO.builder()
                        .mname(m.getMname())
                        .email(m.getEmail())
                        .address(m.getAddress())
                        .party_name(m.getParty_name())
                        .company_number(m.getCompany_number())
                        .mfile(m.getMfile())
                        .careerFile(m.getCareerFile())
                        .build())
                .collect(Collectors.toList());
    }

    // 기업별 회원 목록 조회
    public List<MemberResponseDTO> memberListByCompany(Long companyId) {
        return memberRepository.findByCompany_CompanyId(companyId).stream()
                .map(m -> MemberResponseDTO.builder()
                        .mname(m.getMname())
                        .email(m.getEmail())
                        .address(m.getAddress())
                        .party_name(m.getParty_name())
                        .company_number(m.getCompany_number())
                        .mfile(m.getMfile())
                        .careerFile(m.getCareerFile())
                        .build())
                .collect(Collectors.toList());
    }






}

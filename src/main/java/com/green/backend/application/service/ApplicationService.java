package com.green.backend.application.service;

import com.green.backend.application.dto.ApplicationDTO;
import com.green.backend.application.entity.Application;
import com.green.backend.application.repository.ApplicationRepository;
import com.green.backend.expert.entity.Expert;
import com.green.backend.expert.repository.ExpertRepository;
import com.green.backend.member.entity.Member;
import com.green.backend.member.repository.MemberRepository;
import com.green.backend.util.JwtUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ApplicationService {
    private final JwtUtil jwtUtil;
    private final ApplicationRepository applicationRepository; // 답사신청데이터 db에 저장/조회
    private final MemberRepository memberRepository; // 기업 데이터 조회
    private final ExpertRepository expertRepository; // 전문가 데이터 조회

     // [1] 답사신청 등록
    // 클라이언트로 ApplicationDto 전달받음 -> member/ expert 유효성검사 -> 답사신청 정보 DB 저장
     public boolean CreateVisitRequest (String token, ApplicationDTO applicationDTO){
         // 1. 토큰에서 회원 번호 추출(클라이언트가 아닌 토큰을 신뢰)
         Long memberId = jwtUtil.validateToken(token);
         // (2) 회원 fk정보 조회
         Optional<Member> member =
            memberRepository.findById( memberId ); // 회원번호 가져와서 회원(member)정보를 조회 optional로 가져와야 됨 (그냥)
         if( !member.isPresent() ){ return false; } // 회원 정보가 없으면 불러오기 실패
        Application newApplication = new Application(); // 엔티티 직접 생성
         // [클라이언트 입력값]
         newApplication.setContent(applicationDTO.getContent()); // 오직 사용자가 입력한 '신청 내용'만 DTO에서 가져옵니다.
         newApplication.setMemberId(member.get());
         newApplication.setMemberId(member.get()); // 토큰에서 가져온 회원 정보
         newApplication.setTimes(0);                       // 정기차수: 0 (최초 답사)
         newApplication.setExpertId(null);                 // 전문가 번호: x (null)
         newApplication.setDueDate(null);                  // 답사일: 전문가 배정 시 확정되므로 null
         newApplication.setOpinion(null);

         Application savedapplication = applicationRepository.save(newApplication); // 완성된 Application엔티티를 DB에 저장
         return savedapplication.getDetailId() > 0; // DB 저장 및 검증
     }

     // [2] 답사 신청 조회
    public List<ApplicationDTO> ReadVisitRequest( String token ){ // 1. 토큰에서 회원 번호 추출 (위와 동일)
         Long memberId = jwtUtil.validateToken(token); // 2. 토큰에서 회원 정보 추출
        Optional<Member> memberOptional = memberRepository.findById(memberId); // 회원 정보 조회
        if (memberOptional.isEmpty()) { throw new IllegalArgumentException("존재하지 않는 회원입니다."); // 회원 없으면 예외 처리
        }
        List<Application> applications = applicationRepository.findAllByMemberId(memberOptional.get()); // 회원 기준 신청목록 조회
        // DB에서 찾은 회원정보 Repository에 넘겨주기 -> 이 회원이 쓴 답사 신청서 DB에서 싹 다 긁어와!

        return applications.stream() // 리스트 -> 스트림
                            .map(Application::toDto) // 엔티티 -> DTO
                            .collect(Collectors.toList()); // DTO -> 리스트
    }

    // [1] 관리자) 모든 답사내역 목록 조회
    public List<ApplicationDTO> readAllVisitRequests() {
         List<Application> applications = applicationRepository.findAll(); // DB에서 모든 신청 데이터 조회
        return applications.stream() // 리스트 -> 스트림
                .map(Application::toDto) // 엔티티 -> DTO
                .toList(); // DTO 리스트로 반환
    }


}

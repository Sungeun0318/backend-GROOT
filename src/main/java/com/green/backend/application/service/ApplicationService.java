package com.green.backend.application.service;

import com.green.backend.application.dto.ApplicationDTO;
import com.green.backend.application.entity.Application;
import com.green.backend.application.repository.ApplicationRepository;
import com.green.backend.expert.entity.Expert;
import com.green.backend.expert.repository.ExpertRepository;
import com.green.backend.member.dto.LoginTokenDTO;
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
         // 토큰에서 회원번호 추출
         LoginTokenDTO membertoken = jwtUtil.validateToken(token);
         Long memberId = membertoken.getMid();


         //  회원 유효성 검사
         Member member = memberRepository.findById(memberId).orElse(null);
         if(member==null){return false; }


         // 초기 신청 상태, 차수
         applicationDTO.setSurveyStatus("신청"); // 초기 상태 : "신청"
         applicationDTO.setTimes(0); // 초기 차수 : 0

         // 회원 정보 불러오기
         Application saveEntity = applicationDTO.toEntity(); // dto -> Entity 변환
         saveEntity.setMemberId(member); // 회원 fk 연결

         // times 차수 +-1
         int finalLastTime = applicationRepository.findLastTime(memberId); // 해당 회원의 마지막 차수 조회
         saveEntity.setTimes(finalLastTime == 0 ? finalLastTime : finalLastTime +1); // 차수 없으면 0, 있으면 +1

         // 정보 저장 및 확인
         Application savedapplication = applicationRepository.save(saveEntity); // 완성된 Application엔티티를 DB에 저장
         return savedapplication.getDetailId() > 0; // DB 저장 및 검증
     }

     // [2] 답사 신청 조회
    public List<ApplicationDTO> ReadVisitRequest( String token ){ // 1. 토큰에서 회원 번호 추출 (위와 동일)

        LoginTokenDTO membertoken = jwtUtil.validateToken(token);
        Long memberId = membertoken.getMid(); // 2. 토큰에서 회원 정보 추출
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

    // [2] 관리자) 전문가 배정
    @Transactional
    public boolean assignExpert( ApplicationDTO dto ){
         Application application = applicationRepository.findById(dto.getDetailId() ) // 답사번호로 신청 정보 조회
                 .orElseThrow(()->new IllegalArgumentException("답사 없음")); // 없으면 예외 발생

         Expert expert = expertRepository.findById(dto.getExpertId().longValue()) // 전문가번호로 전문가 조회
        .orElseThrow(() -> new IllegalArgumentException("전문가 없음")); // 없으면 예외 발생

        application.setExpertId(expert); // 답사에 전문가 연결
        application.setDueDate(dto.getDueDate()); // 답사 예정일 설정

        application.setSurveyStatus("진행중"); // 상태를 "진행중"으로 변경
        return true; // 정상처리 완료
    }
}

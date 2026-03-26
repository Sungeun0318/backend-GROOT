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
    public List<ApplicationDTO> ReadVisitRequest( String token ){
        // 1. 토큰에서 회원 번호 추출 (위와 동일)
         Long memberId = jwtUtil.validateToken(token);
        // 2. 회원 정보 조회 및 검증
        Optional<Member> memberOptional = memberRepository.findById(memberId);
        if (memberOptional.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 회원입니다.");
        }
        // 3. 해당 회원이 신청한 모든 답사 내역 조회 (Repository에 추가했던 메서드 사용)
        List<Application> applications = applicationRepository.findAllByMemberId(memberOptional.get());
        // DB에서 찾은 회원정보 Repository에 넘겨주기 -> 이 회원이 쓴 답사 신청서 DB에서 싹 다 긁어와!

        // 4. Entity 리스트를 DTO 리스트로 변환하여 프론트엔드에 전달
        // DB에서 꺼낸건 날것의 Entity 리스트, 쓸데없는 정보도 넘기면 안됨~
        return applications.stream() // 리스트 정보를 컨베이어벨트에 올림
                            .map(Application::toDto) // 벨트 위에서 날것의 Entity를 DTO로 하나씩 변환
                            .collect(Collectors.toList()); // 포장된 DTO를 다시 리스트로 변환해서 최종 반환함!
    }
}

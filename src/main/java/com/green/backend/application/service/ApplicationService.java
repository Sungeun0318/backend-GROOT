package com.green.backend.application.service;

import com.green.backend.application.dto.ApplicationDTO;
import com.green.backend.application.entity.Application;
import com.green.backend.application.repository.ApplicationRepository;
import com.green.backend.expert.entity.Expert;
import com.green.backend.expert.repository.ExpertRepository;
import com.green.backend.member.entity.Member;
import com.green.backend.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final MemberRepository memberRepository;
    private final ExpertRepository expertRepository;
     // [1] 답사신청 등록
     public boolean CreateVisitRequest (ApplicationDTO applicationDTO){
         Application saveapplication = applicationDTO.toEntity();

         Optional<Member > member =
            memberRepository.findById( applicationDTO.getMemberId() );
         if( !member.isPresent() ){ return false; }
         saveapplication.setMemberId( member.get() );


         Optional<Expert> expert = expertRepository.findById( applicationDTO.getExpertId() );
         if( !expert.isPresent() ){ return false; }
         saveapplication.setExpertId( expert.get() );

         Application savedapplication = applicationRepository.save(saveapplication);
         if( savedapplication.getDetailId() > 0){ return true; }
         else{ return false; }
     }
     // [*] 과제 : 위 코드에 대한 주석처리를 만들어오기 ~
}

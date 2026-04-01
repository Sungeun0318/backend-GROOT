package com.green.backend.expert.service;


import com.green.backend.application.dto.ApplicationDTO;
import com.green.backend.application.entity.Application;
import com.green.backend.expert.dto.ExpertDTO;
import com.green.backend.expert.entity.Expert;
import com.green.backend.expert.repository.ExpertRepository;
import com.green.backend.expertreport.repository.ExpertReportRepository;
import com.green.backend.member.entity.Member;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
@RequiredArgsConstructor
public class ExpertService {

    private final ExpertRepository expertRepository;

    // [1] 전문가 정보 등록
    public boolean createSpecialist(ExpertDTO expertDTO) {
        try {expertRepository.save(expertDTO.toEntity());return true;
        } catch (Exception e) {return false;}
    }

    // [2] 전문가 목록 전체 조회
    public List<ExpertDTO> GetAllSpecialist() { // 1. 토큰에서 회원 번호 추출 (위와 동일)
        return expertRepository.findAll().stream() // 리스트 -> 스트림
                .map(Expert::toDto) // 엔티티 -> DTO
                .collect(Collectors.toList()); // DTO -> 리스트
    }

    // [3] 전문가 개별 조회
    public ExpertDTO GetSpecialist(@PathVariable Long expertId) {
        Expert expert =  expertRepository.findById(expertId)
                .orElseThrow(() -> new IllegalArgumentException("해당 전문가가 존재하지 않습니다."));
        return expert.toDto();
    }

    // [4] 전문가 수정
    public boolean updateSpecialist(Long expertId, ExpertDTO expertDTO){
        // 1. 수정할 대상이 있는지 먼저 찾기
        Expert expert = expertRepository.findById(expertId)
                .orElse(null);
        if (expert == null) {
            return false;
        }
            // 2. 찾아온 엔티티에 DTO 내용을 덮어씌우기 (Setter 사용)
            expert.setExpertName(expertDTO.getExpertName());
            expert.setExpertState(expertDTO.getExpertState());
            expert.setExpertEmail(expertDTO.getExpertEmail());
            expert.setExpertNumber(expertDTO.getExpertNumber());
            expertRepository.save(expert);
            return true;
        }

    // [5] 전문가 삭제
    // ExpertService.java
    public boolean deleteSpecialist(Long expertId) {
        try { if(expertRepository.existsById(expertId)) {
                expertRepository.deleteById(expertId);
                return true;}
            return false; // 해당 ID가 없을 때
        }catch (Exception e) {
            return false;
        }
    }
}

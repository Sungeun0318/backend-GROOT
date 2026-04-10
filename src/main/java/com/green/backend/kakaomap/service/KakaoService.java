package com.green.backend.kakaomap.service;

import com.green.backend.certification.repository.CertificationRepository;
import com.green.backend.expertreport.repository.ExpertReportRepository;
import com.green.backend.kakaomap.dto.KakaomapDto;
import com.green.backend.kakaomap.dto.treeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KakaoService {

    // 기업 정보
    private final ExpertReportRepository expertReportRepository;
    private final CertificationRepository certificationRepository;

    // 전체 기업 목록
    public List<KakaomapDto> kakaomap() {
        return certificationRepository.findAllKakaomap();
    }

    // 특정 기업의 나무 목록
    public List<treeDto> treeMap(Long memberId) {
        return expertReportRepository.findTreeByMemberId(memberId);
    }

}
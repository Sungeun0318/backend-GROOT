package com.green.backend.certification.service;

import com.green.backend.certification.dto.CertStatusDTO;
import com.green.backend.certification.dto.GradeInfoDTO;
import com.green.backend.certification.entity.Certification;
import com.green.backend.certification.repository.CertificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CertificationService {

    private final CertificationRepository certificationRepository;

    // 등급 기준 (탄소흡수량 kg 기준)
    // 씨앗: 0~500, 새싹: 500~2000, 숲: 2000~5000, 산림: 5000+
    private static final double[] CARBON_MIN = {1, 500, 2000, 5000};
    private static final double[] CARBON_MAX = {500, 2000, 5000, -1};
    private static final String[] GRADE_NAMES = {"씨앗", "새싹", "숲", "산림"};
    private static final String[] GRADE_EMOJIS = {"🌱", "🌿", "🌳", "🏔️"};
    private static final String[] GRADE_CARBON_TEXT = {"500kg 미만", "500~2,000kg", "2,000~5,000kg", "5,000kg+"};

    // 1. 인증 현황 조회
    public CertStatusDTO getStatus(Long memberId) {
        Certification cert = certificationRepository.findByExpertReport_Application_MemberId_Mid(memberId);

        if (cert == null) {
            return CertStatusDTO.builder()
                    .grade("없음")
                    .treeCount(0)
                    .totalCarbonAbsorption(0)
                    .carbonUntilNext(CARBON_MIN[1])
                    .nextGrade(GRADE_NAMES[0])
                    .currentGradeIndex(-1)
                    .progress(0)
                    .build();
        }

        double carbon = cert.getTotalCarbonAbsorption();
        int gradeIndex = getGradeIndex(carbon);
        double carbonUntilNext = 0;
        String nextGrade = null;
        double progress = 100;

        if (gradeIndex < 3) {
            carbonUntilNext = CARBON_MIN[gradeIndex + 1] - carbon;
            nextGrade = GRADE_NAMES[gradeIndex + 1];
            double rangeMin = CARBON_MIN[gradeIndex];
            double rangeMax = CARBON_MAX[gradeIndex];
            progress = ((carbon - rangeMin) / (rangeMax - rangeMin)) * 100;
//            현재 등급(현재 등급의 맞는 탄소 범위 ) 탄소 흡수량 - 현재 탄소 총 흡수량
//                    / 최고 등급 탄소 흡수량 - 현재 탄소 총 흡수량 * 100
//            탄소흡수량 기준 몇 개월?  -> 1년 기준?
//            첫 답사때 인증마크 미제공 최소 6개월 이상 유지 시 지급 (2차 답사때 점검하고 그때부터 1년 예측한 탄소흡수량으로 지급 예정)
        }

        return CertStatusDTO.builder()
                .grade(cert.getGrade())
                .treeCount(cert.getTreeCount())
                .totalCarbonAbsorption(carbon)
                .expireDate(cert.getExpireDate())
                .carbonUntilNext(carbonUntilNext)
                .nextGrade(nextGrade)
                .currentGradeIndex(gradeIndex)
                .progress(progress)
                .build();
    }

    // 2. 등급 기준 목록
    public List<GradeInfoDTO> getGrades() {
        List<GradeInfoDTO> grades = new ArrayList<>();
        for (int i = 0; i < GRADE_NAMES.length; i++) {
            grades.add(GradeInfoDTO.builder()
                    .name(GRADE_NAMES[i])
                    .emoji(GRADE_EMOJIS[i])
                    .minCarbon(CARBON_MIN[i])
                    .maxCarbon(CARBON_MAX[i])
                    .carbon(GRADE_CARBON_TEXT[i])
                    .build());
        }
        return grades;
    }

    // 탄소흡수량으로 등급 인덱스 계산
    private int getGradeIndex(double carbon) {
        if (carbon >= 5000) return 3;
        if (carbon >= 2000) return 2;
        if (carbon >= 500) return 1;
        return 0;
    }
}

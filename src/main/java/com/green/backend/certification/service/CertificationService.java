package com.green.backend.certification.service;

import com.green.backend.application.entity.Application;
import com.green.backend.application.repository.ApplicationRepository;
import com.green.backend.carbon.service.CarbonCalculator;
import com.green.backend.certification.dto.CertStatusDTO;
import com.green.backend.certification.dto.GradeInfoDTO;
import com.green.backend.certification.entity.Certification;
import com.green.backend.certification.repository.CertificationRepository;
import com.green.backend.expertreport.entity.ExpertReport;
import com.green.backend.expertreport.repository.ExpertReportRepository;
import com.green.backend.member.entity.Member;
import com.green.backend.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CertificationService {

    private final CertificationRepository certificationRepository;
    private final MemberRepository memberRepository;
    private final ApplicationRepository applicationRepository;
    private final ExpertReportRepository expertReportRepository;
    private final CarbonCalculator carbonCalculator;

    // 등급 기준 (탄소흡수량 kg 기준)
    // 씨앗: 0~500, 새싹: 500~2000, 숲: 2000~5000, 산림: 5000+
    private static final double[] CARBON_MIN = {1, 500, 2000, 5000};
    private static final double[] CARBON_MAX = {500, 2000, 5000, -1};
    private static final String[] GRADE_NAMES = {"씨앗", "새싹", "숲", "산림"};
    private static final String[] GRADE_EMOJIS = {"🌱", "🌿", "🌳", "🏔️"};
    private static final String[] GRADE_CARBON_TEXT = {"500kg 미만", "500~2,000kg", "2,000~5,000kg", "5,000kg+"};

    // 1. 회원별 인증 현황 (실제 나무 데이터로 live 계산)
    public CertStatusDTO getStatus(Long memberId) {
        List<ExpertReport> trees = getTreesByMemberId(memberId);
        double totalCarbon = 0;
        for (ExpertReport tree : trees) {
            totalCarbon += calculateCumulativeAbsorption(tree);
        }

        // expireDate 만 인증 테이블에서 가져옴 (나머지는 live 계산)
        Certification cert = certificationRepository.findByMember_Mid(memberId);
        LocalDateTime expireDate = cert != null ? cert.getExpireDate() : null;

        return buildStatus(trees.size(), totalCarbon, expireDate);
    }

    // 1-2. 기업별 인증 현황 (실제 나무 데이터로 live 계산, companyId==null 이면 전체 기업 합산)
    public CertStatusDTO getStatusByCompany(Long companyId) {
        List<Member> members;
        if (companyId == null) {
            members = memberRepository.findAll();
        } else {
            members = memberRepository.findByCompany_CompanyId(companyId);
        }

        int totalTreeCount = 0;
        double totalCarbon = 0;
        LocalDateTime latestExpire = null;

        for (Member m : members) {
            List<ExpertReport> trees = getTreesByMemberId(m.getMid());
            totalTreeCount += trees.size();
            for (ExpertReport tree : trees) {
                totalCarbon += calculateCumulativeAbsorption(tree);
            }

            Certification cert = certificationRepository.findByMember_Mid(m.getMid());
            if (cert != null && cert.getExpireDate() != null &&
                    (latestExpire == null || cert.getExpireDate().isAfter(latestExpire))) {
                latestExpire = cert.getExpireDate();
            }
        }

        return buildStatus(totalTreeCount, totalCarbon, latestExpire);
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

    // ==================== 공통 헬퍼 ====================

    private CertStatusDTO buildStatus(int treeCount, double totalCarbon, LocalDateTime expireDate) {
        if (treeCount == 0 || totalCarbon <= 0) {
            return CertStatusDTO.builder()
                    .grade("없음")
                    .treeCount(treeCount)
                    .totalCarbonAbsorption(0)
                    .expireDate(expireDate)
                    .carbonUntilNext(CARBON_MIN[1])
                    .nextGrade(GRADE_NAMES[0])
                    .currentGradeIndex(-1)
                    .progress(0)
                    .build();
        }

        int gradeIndex = getGradeIndex(totalCarbon);
        double carbonUntilNext = 0;
        String nextGrade = null;
        double progress = 100;

        if (gradeIndex < 3) {
            carbonUntilNext = CARBON_MIN[gradeIndex + 1] - totalCarbon;
            nextGrade = GRADE_NAMES[gradeIndex + 1];
            double rangeMin = CARBON_MIN[gradeIndex];
            double rangeMax = CARBON_MAX[gradeIndex];
            progress = ((totalCarbon - rangeMin) / (rangeMax - rangeMin)) * 100;
        }

        return CertStatusDTO.builder()
                .grade(GRADE_NAMES[gradeIndex])
                .treeCount(treeCount)
                .totalCarbonAbsorption(Math.round(totalCarbon * 100.0) / 100.0)
                .expireDate(expireDate)
                .carbonUntilNext(Math.round(carbonUntilNext * 100.0) / 100.0)
                .nextGrade(nextGrade)
                .currentGradeIndex(gradeIndex)
                .progress(Math.round(progress * 100.0) / 100.0)
                .build();
    }

    /*
     * 나무 등록일(ExpertReport.createDate)부터 현재까지의 누적 CO₂ 흡수량(kg) 계산
     * = 연간 흡수량 × 경과 년수 (일 단위로 환산)
     */
    private double calculateCumulativeAbsorption(ExpertReport tree) {
        double annualAbsorption = carbonCalculator.calculateAnnualAbsorption(tree);
        LocalDateTime createDate = tree.getCreateDate();
        if (createDate == null) return annualAbsorption; // 등록일 없으면 1년치로 간주

        long daysElapsed = ChronoUnit.DAYS.between(createDate, LocalDateTime.now());
        if (daysElapsed <= 0) return 0;

        double yearsElapsed = daysElapsed / 365.0;
        return annualAbsorption * yearsElapsed;
    }

    private List<ExpertReport> getTreesByMemberId(Long memberId) {
        Member member = memberRepository.findById(memberId).orElse(null);
        if (member == null) return new ArrayList<>();

        return applicationRepository.findAllByMemberId(member).stream()
                .max(java.util.Comparator.comparingInt(Application::getTimes))
                .map(expertReportRepository::findAllByApplication)
                .orElse(new ArrayList<>());
    }

    // 탄소흡수량으로 등급 인덱스 계산
    private int getGradeIndex(double carbon) {
        if (carbon >= 5000) return 3;
        if (carbon >= 2000) return 2;
        if (carbon >= 500) return 1;
        return 0;
    }
}

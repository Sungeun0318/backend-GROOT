package com.green.backend.carbon.service;

import com.green.backend.carbon.dto.*;
import com.green.backend.expertreport.entity.ExpertReport;
import com.green.backend.expertreport.repository.ExpertReportRepository;
import com.green.backend.application.entity.Application;
import com.green.backend.application.repository.ApplicationRepository;
import com.green.backend.member.entity.Member;
import com.green.backend.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarbonService {

    private final CarbonCalculator carbonCalculator;
    private final WeatherApiService weatherApiService;
    private final ExpertReportRepository expertReportRepository;
    private final ApplicationRepository applicationRepository;
    private final MemberRepository memberRepository;

    /**
     * 기업별 탄소 예측 대시보드 데이터
     * - 현재 총 CO₂ 저장량
     * - 연간 흡수량
     * - 탭1: 월별 예측 (12개월)
     * - 탭2: 10년 예측
     */
    public CarbonPredictionDTO getPrediction(Long memberId, String regionName) {
        // 1. 해당 기업의 모든 나무 조회 (회원 → 답사 → 나무기록)
        List<ExpertReport> trees = getTreesByMemberId(memberId);

        if (trees.isEmpty()) {
            return CarbonPredictionDTO.builder()
                    .currentCo2(0)
                    .annualAbsorption(0)
                    .totalTreeCount(0)
                    .yearlyPredictions(new ArrayList<>())
                    .build();
        }

        // 2. 기상청 현재 날씨 (기온 보정용)
        WeatherDTO weather = null;
        try {
            weather = weatherApiService.getCurrentWeather(regionName != null ? regionName : "서울");
        } catch (Exception e) {
            log.warn("기상청 API 호출 실패, 기본 기온 사용: {}", e.getMessage());
        }

        // 3. 개별 나무 계산 → 합산
        double totalCurrentCo2 = 0;
        double totalAnnualAbsorption = 0;
        List<YearlyPredictionDTO> totalYearly = null;

        for (ExpertReport tree : trees) {
            totalCurrentCo2 += carbonCalculator.calculateCurrentCo2(tree);
            totalAnnualAbsorption += carbonCalculator.calculateAnnualAbsorption(tree);

            // 년별 예측 합산 (나무 나이 + 날씨 1년 보정 포함)
            List<YearlyPredictionDTO> yearly = carbonCalculator.predictYearly(tree, 10, weather);
            if (totalYearly == null) {
                totalYearly = new ArrayList<>(yearly);
            } else {
                for (int i = 0; i < yearly.size(); i++) {
                    totalYearly.get(i).setCo2Total(
                            totalYearly.get(i).getCo2Total() + yearly.get(i).getCo2Total()
                    );
                    totalYearly.get(i).setCo2Absorbed(
                            totalYearly.get(i).getCo2Absorbed() + yearly.get(i).getCo2Absorbed()
                    );
                }
            }
        }

        return CarbonPredictionDTO.builder()
                .currentCo2(Math.round(totalCurrentCo2 * 100.0) / 100.0)
                .annualAbsorption(Math.round(totalAnnualAbsorption * 100.0) / 100.0)
                .totalTreeCount(trees.size())
                .yearlyPredictions(totalYearly)
                .build();
    }

    /**
     * 회원 ID → 해당 기업의 모든 나무기록 조회
     */
    private List<ExpertReport> getTreesByMemberId(Long memberId) {
        Member member = memberRepository.findById(memberId).orElse(null);
        if (member == null) return new ArrayList<>();

        List<Application> applications = applicationRepository.findAllByMemberId(member);
        List<ExpertReport> allTrees = new ArrayList<>();

        for (Application app : applications) {
            List<ExpertReport> trees = expertReportRepository.findAllByApplication(app);
            allTrees.addAll(trees);
        }

        return allTrees;
    }
}

package com.green.backend.carbon.service;

import com.green.backend.application.entity.Application;
import com.green.backend.application.repository.ApplicationRepository;
import com.green.backend.carbon.dto.*;
import com.green.backend.expertreport.entity.ExpertReport;
import com.green.backend.expertreport.repository.ExpertReportRepository;
import com.green.backend.member.entity.Member;
import com.green.backend.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final MemberRepository memberRepository;
    private final ApplicationRepository applicationRepository;
    private final ExpertReportRepository expertReportRepository;
    private final CarbonCalculator carbonCalculator;

    // ==================== 1. 대시보드 요약 ====================
    public DashboardSummaryDTO getSummary(Long memberId) {
        List<ExpertReport> trees = getTreesByMemberId(memberId);
        List<Application> applications = getApplicationsByMemberId(memberId);

        // 총 탄소흡수량
        double totalAbsorption = 0;
        for (ExpertReport tree : trees) {
            totalAbsorption += carbonCalculator.calculateAnnualAbsorption(tree);
        }

        // 인증 상태: 나무 수 기반 등급 판단
        String certStatus = getCertStatus(trees.size());

        // 다음 점검 일정: 미래 답사일 중 가장 가까운 것
        String nextSchedule = applications.stream()
                .filter(a -> a.getDueDate() != null && a.getDueDate().isAfter(LocalDateTime.now()))
                .map(a -> a.getDueDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .min(String::compareTo)
                .orElse("예정 없음");

        return DashboardSummaryDTO.builder()
                .treeCount(trees.size())
                .totalAbsorption(Math.round(totalAbsorption * 100.0) / 100.0)
                .certStatus(certStatus)
                .nextSchedule(nextSchedule)
                .build();
    }

    // ==================== 2. 월별 탄소흡수량 ====================
    public List<MonthlyAbsorptionDTO> getMonthlyAbsorption(Long memberId) {
        List<ExpertReport> trees = getTreesByMemberId(memberId);

        // 연간 총 흡수량
        double totalAnnual = 0;
        for (ExpertReport tree : trees) {
            totalAnnual += carbonCalculator.calculateAnnualAbsorption(tree);
        }

        // 월별 계절 보정 적용
        String[] months = {"1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"};
        double[] seasonFactors = {0.05, 0.05, 1.0, 1.0, 1.0, 1.3, 1.3, 1.3, 0.8, 0.8, 0.8, 0.05};
        double totalFactor = 0;
        for (double f : seasonFactors) totalFactor += f;

        List<MonthlyAbsorptionDTO> result = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            double monthValue = totalAnnual * (seasonFactors[i] / totalFactor);
            result.add(MonthlyAbsorptionDTO.builder()
                    .month(months[i])
                    .value(Math.round(monthValue * 100.0) / 100.0)
                    .build());
        }
        return result;
    }

    // ==================== 3. 수종별 분포 ====================
    public List<SpeciesDistributionDTO> getSpeciesDistribution(Long memberId) {
        List<ExpertReport> trees = getTreesByMemberId(memberId);
        if (trees.isEmpty()) return new ArrayList<>();

        // 수종별 그룹핑
        Map<String, Long> speciesCount = trees.stream()
                .collect(Collectors.groupingBy(ExpertReport::getTreeType, Collectors.counting()));

        int total = trees.size();
        return speciesCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(e -> SpeciesDistributionDTO.builder()
                        .name(e.getKey())
                        .count(e.getValue().intValue())
                        .ratio(Math.round(e.getValue() * 100f / total))
                        .build())
                .collect(Collectors.toList());
    }

    // ==================== 4. 최근 신청 현황 ====================
    public List<RecentApplicationDTO> getRecentApplications(Long memberId) {
        List<Application> applications = getApplicationsByMemberId(memberId);

        return applications.stream()
                .sorted(Comparator.comparing(Application::getDetailId).reversed())
                .limit(5)
                .map(app -> {
                    // 해당 답사의 나무기록에서 수종과 그루 수 추출
                    List<ExpertReport> trees = expertReportRepository.findAllByApplication(app);
                    String species = trees.isEmpty() ? "-" : trees.get(0).getTreeType();
                    int qty = trees.size();
                    String date = app.getDueDate() != null
                            ? app.getDueDate().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"))
                            : "-";

                    return RecentApplicationDTO.builder()
                            .id(app.getDetailId())
                            .species(species)
                            .qty(qty)
                            .date(date)
                            .status(app.getSurveyStatus())
                            .build();
                })
                .collect(Collectors.toList());
    }

    // ==================== 5. 예정 일정 ====================
    public List<UpcomingScheduleDTO> getUpcomingSchedules(Long memberId) {
        List<Application> applications = getApplicationsByMemberId(memberId);

        return applications.stream()
                .filter(a -> a.getDueDate() != null)
                .sorted(Comparator.comparing(Application::getDueDate))
                .limit(5)
                .map(app -> {
                    String type;
                    switch (app.getSurveyStatus()) {
                        case "신청" -> type = "답사";
                        case "진행중" -> type = "점검";
                        case "완료" -> type = "보고";
                        default -> type = "기타";
                    }
                    return UpcomingScheduleDTO.builder()
                            .id(app.getDetailId())
                            .title(app.getContent() != null ? app.getContent() : "답사 일정")
                            .date(app.getDueDate().format(DateTimeFormatter.ofPattern("yyyy.MM.dd")))
                            .type(type)
                            .build();
                })
                .collect(Collectors.toList());
    }

    // ==================== 공통 ====================
    private List<ExpertReport> getTreesByMemberId(Long memberId) {
        Member member = memberRepository.findById(memberId).orElse(null);
        if (member == null) return new ArrayList<>();

        List<Application> applications = applicationRepository.findAllByMemberId(member);
        List<ExpertReport> allTrees = new ArrayList<>();
        for (Application app : applications) {
            allTrees.addAll(expertReportRepository.findAllByApplication(app));
        }
        return allTrees;
    }

    private List<Application> getApplicationsByMemberId(Long memberId) {
        Member member = memberRepository.findById(memberId).orElse(null);
        if (member == null) return new ArrayList<>();
        return applicationRepository.findAllByMemberId(member);
    }

    private String getCertStatus(int treeCount) {
        if (treeCount >= 501) return "산림";
        if (treeCount >= 201) return "숲";
        if (treeCount >= 51) return "새싹";
        if (treeCount >= 1) return "씨앗";
        return "미인증";
    }
}

package com.green.backend.kakaomap.service;

import com.green.backend.carbon.service.CarbonCalculator;
import com.green.backend.expertreport.entity.ExpertReport;
import com.green.backend.expertreport.repository.ExpertReportRepository;
import com.green.backend.kakaomap.dto.KakaomapDto;
import com.green.backend.kakaomap.dto.treeDto;
import com.green.backend.member.entity.Member;
import com.green.backend.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KakaoService {

    private final ExpertReportRepository expertReportRepository;
    private final MemberRepository memberRepository;
    private final CarbonCalculator carbonCalculator;

    // 전체 기업 목록
    public List<KakaomapDto> kakaomap() {
        List<Member> members = memberRepository.findAll();

        return members.stream()
                .filter(member -> member.getCompany() != null)
                .map(member -> {
                    List<ExpertReport> latestReports =
                            expertReportRepository.findLatestReportsByMemberId(member.getMid());

                    int treeCount = latestReports.size();

                    double totalCarbonAbsorption = latestReports.stream()
                            .mapToDouble(carbonCalculator::calculateAnnualAbsorption)
                            .sum();

                    String grade = getCertGrade(totalCarbonAbsorption);

                    return KakaomapDto.builder()
                            .memberId(member.getMid())
                            .companyName(member.getCompany().getCompanyName())
                            .partyName(member.getParty_name())
                            .address(member.getAddress())
                            .treeCount(treeCount)
                            .totalCarbonAbsorption(totalCarbonAbsorption)
                            .grade(grade)
                            .build();
                })
                .toList();
    }

    // 특정 기업의 최신 차수 나무 목록
    public List<treeDto> treeMap(Long memberId) {
        return expertReportRepository.findTreeByMemberId(memberId);
    }

    // ReportService와 동일한 등급 계산
    private String getCertGrade(double totalCarbonAbsorption) {
        if (totalCarbonAbsorption < 500) {
            return "씨앗";
        } else if (totalCarbonAbsorption < 2000) {
            return "새싹";
        } else if (totalCarbonAbsorption < 5000) {
            return "숲";
        } else {
            return "산림";
        }
    }
}
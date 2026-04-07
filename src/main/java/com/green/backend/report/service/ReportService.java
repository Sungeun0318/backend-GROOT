package com.green.backend.report.service;

import com.green.backend.certification.entity.Certification;
import com.green.backend.certification.repository.CertificationRepository;
import com.green.backend.report.dto.MemberCompanyDto;
import com.green.backend.report.dto.ReportDto;
import com.green.backend.report.dto.ReportPreviewDTO;
import com.green.backend.report.dto.SpeciesDetailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final CertificationRepository certificationRepository;

    public ReportPreviewDTO preview(Long mid) {

        Certification certification = certificationRepository.findByMember_Mid(mid);
        List<ReportDto> reportList = certificationRepository.findByMemberId(mid);



        List<MemberCompanyDto> companyList = certificationRepository.findMemberCompany(mid);

        String companyInfo = null;

        if (companyList != null && !companyList.isEmpty()) {
            MemberCompanyDto dto = companyList.get(0);

            companyInfo = dto.getCompanyName() + " / " + dto.getPartyName();
        }

        if (certification == null) {
            throw new IllegalArgumentException("인증 정보가 없습니다.");
        }

        if (reportList == null || reportList.isEmpty()) {
            return ReportPreviewDTO.builder()
                    .issuedDate(null)
                    .totalCount(0)
                    .totalCarbonAbsorption(0.0)
                    .certGrade(null)
                    .speciesDetail(List.of())
                    .build();
        }

        // 기준 차수 선택 (최신 차수)
        int targetTimes = reportList.stream()
                .mapToInt(ReportDto::getTimes)
                .max()
                .orElse(0);

        // 같은 차수만 필터링
        List<ReportDto> filteredList = reportList.stream()
                .filter(r -> r.getTimes() == targetTimes)
                .toList();

        // 같은 차수 전체 나무 수
        int totalCount = filteredList.size();

        // treeType별 개수 세기
        Map<String, Long> groupedMap = filteredList.stream()
                .collect(Collectors.groupingBy(
                        ReportDto::getTreeType,
                        Collectors.counting()
                ));

        // speciesDetail 생성
        List<SpeciesDetailDTO> speciesDetails = groupedMap.entrySet().stream()
                .map(entry -> {
                    String treeType = entry.getKey();
                    int count = entry.getValue().intValue();

                    double totalCarbonAbsorption = 0.0;

                    if (certification != null) {
                        totalCarbonAbsorption = certification.getTotalCarbonAbsorption();
                    }

                    double ratio = totalCount == 0 ? 0.0 : ((double) count / totalCount) * 100.0;

                    return SpeciesDetailDTO.builder()
                            .treeType(treeType)
                            .count(count)
                            .carbonAbsorption(totalCarbonAbsorption)
                            .ratio(ratio)
                            .build();
                })
                .toList();

        // 전체 탄소흡수량
        double totalCarbonAbsorption = speciesDetails.stream()
                .mapToDouble(SpeciesDetailDTO::getCarbonAbsorption)
                .sum();

        // 발급일 / 인증등급
        String issuedDate = null;
        String certGrade = null;

        if (certification != null) {
            if (certification.getIssuedDate() != null) {
                issuedDate = certification.getIssuedDate().toLocalDate() .toString();
            }
            certGrade = certification.getGrade();
        }

        return ReportPreviewDTO.builder()
                .companyName(companyInfo)
                .issuedDate(issuedDate)
                .totalCount(totalCount)
                .totalCarbonAbsorption(totalCarbonAbsorption)
                .certGrade(certGrade)
                .speciesDetail(speciesDetails)
                .build();
    }
}
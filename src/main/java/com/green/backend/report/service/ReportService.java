package com.green.backend.report.service;

import com.green.backend.carbon.service.CarbonCalculator;
import com.green.backend.certification.repository.CertificationRepository;
import com.green.backend.expertreport.entity.ExpertReport;
import com.green.backend.expertreport.repository.ExpertReportRepository;
import com.green.backend.report.dto.MemberCompanyDto;
import com.green.backend.report.dto.ReportDto;
import com.green.backend.report.dto.ReportPreviewDTO;
import com.green.backend.report.dto.SpeciesDetailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final CertificationRepository certificationRepository;
    private final CarbonCalculator carbonCalculator;
    private final ExpertReportRepository expertReportRepository;

    public ReportPreviewDTO preview(Long mid, int times) {

        List<ReportDto> reportList = certificationRepository.findByMemberId(mid);
        List<MemberCompanyDto> companyList = certificationRepository.findMemberCompany(mid);

        String companyInfo = null;
        if (companyList != null && !companyList.isEmpty()) {
            MemberCompanyDto dto = companyList.get(0);
            companyInfo = dto.getCompanyName() + " / " + dto.getPartyName();
        }

        // 선택한 차수에 해당하는 데이터만 필터링
        List<ReportDto> filteredList = reportList.stream()
                .filter(r -> r.getTimes() == times)
                .toList();



        if (filteredList.isEmpty()) {
            return ReportPreviewDTO.builder()
                    .companyName(companyInfo)
                    .issuedDate(null)
                    .dueEndDate(null)
                    .selectedTimes(times)
                    .totalCount(0)
                    .totalCarbonAbsorption(0.0)
                    .certGrade(null)
                    .speciesDetail(List.of())
                    .build();
        }

        int totalCount = filteredList.size();

        LocalDate startDate = filteredList.get(0).getDueEndDate();
        LocalDate expireDate = (startDate != null) ? startDate.plusDays(366) : null;

        double totalCarbonAbsorption = filteredList.stream()
                .mapToDouble(report -> {
                    ExpertReport expertReport = expertReportRepository.findById(report.getTreeId())
                            .orElseThrow(() -> new IllegalArgumentException(
                                    "ExpertReport not found. treeId=" + report.getTreeId()
                            ));
                    return carbonCalculator.calculateAnnualAbsorption(expertReport);
                })
                .sum();

        Map<String, List<ReportDto>> groupedByTreeType = filteredList.stream()
                .collect(Collectors.groupingBy(ReportDto::getTreeType));

        List<SpeciesDetailDTO> speciesDetails = groupedByTreeType.entrySet().stream()
                .map(entry -> {
                    String treeType = entry.getKey();
                    List<ReportDto> sameTreeList = entry.getValue();

                    int count = sameTreeList.size();
                    double carbon = sameTreeList.stream()
                            .mapToDouble(report -> {
                                ExpertReport expertReport = expertReportRepository.findById(report.getTreeId())
                                        .orElseThrow(() -> new IllegalArgumentException(
                                                "ExpertReport" + report.getTreeId()));


                                return carbonCalculator.calculateAnnualAbsorption(expertReport);
                            })
                            .sum();

                    double ratio = totalCarbonAbsorption == 0
                            ? 0.0
                            : (carbon / totalCarbonAbsorption) * 100.0;

                    return SpeciesDetailDTO.builder()
                            .treeType(treeType)
                            .count(count)
                            .carbonAbsorption(carbon)
                            .ratio(ratio)
                            .build();
                })
                .toList();

        String certGrade = getCertGrade(totalCarbonAbsorption);

        return ReportPreviewDTO.builder()
                .companyName(companyInfo)
                .issuedDate(startDate != null ? startDate.toString() : null)
                .dueEndDate(expireDate != null ? expireDate.toString() : null)
                .selectedTimes(times)
                .totalCount(totalCount)
                .totalCarbonAbsorption(totalCarbonAbsorption)
                .certGrade(certGrade)
                .speciesDetail(speciesDetails)
                .build();
    }

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
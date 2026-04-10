package com.green.backend.report.service;

import com.green.backend.carbon.service.CarbonCalculator;
import com.green.backend.certification.entity.Certification;
import com.green.backend.certification.repository.CertificationRepository;
import com.green.backend.expertreport.entity.ExpertReport;
import com.green.backend.expertreport.repository.ExpertReportRepository;
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
    private final CarbonCalculator carbonCalculator;
    private final ExpertReportRepository expertReportRepository;
    public ReportPreviewDTO preview(Long mid, int times) {

        Certification certification = certificationRepository.findByMember_Mid(mid);
        List<ReportDto> reportList = certificationRepository.findByMemberId(mid);
        List<MemberCompanyDto> companyList = certificationRepository.findMemberCompany(mid);

        // 기업명 + 담당자 이름 합치기
        String companyInfo = null;
        if (companyList != null && !companyList.isEmpty()) {
            MemberCompanyDto dto = companyList.get(0);
            companyInfo = dto.getCompanyName() + " / " + dto.getPartyName();
        }

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

        System.out.println("filteredList = " + filteredList);

        List<SpeciesDetailDTO> speciesDetails  = filteredList.stream().map( (f)->{

            System.out.println("f.getTreeId() = " + f.getTreeId());
            ExpertReport expertReport =  expertReportRepository.findById( f.getTreeId() ).get();
            double 나무별탄소흡수량 = carbonCalculator.calculateAnnualAbsorption( expertReport );
            System.out.println("나무별탄소흡수량 = " + 나무별탄소흡수량);

            //double ratio = totalCount == 0 ? 0.0 : ((double) count / totalCount) * 100.0;

            return SpeciesDetailDTO.builder()
                    .treeType(f.getTreeType())
                    .count( 3 )
                    .carbonAbsorption(나무별탄소흡수량)
                    .ratio(0.3)
                    .build();
        }).toList();
        


        // List<SpeciesDetailDTO> speciesDetails = filteredList.stream().map( ReportDto ::).toList()



        String issuedDate = null;
        String dueEndDate = null;
        String certGrade = null;
        double totalCarbonAbsorption = 0.0;

        if (certification != null) {
            if (certification.getIssuedDate() != null) {
                issuedDate = certification.getIssuedDate().toString();
            }
            certGrade = certification.getGrade();
            totalCarbonAbsorption = certification.getTotalCarbonAbsorption();
        }

        // 같은 차수 데이터니까 첫 번째 값의 dueEndDate 사용
        if (filteredList.get(0).getDueEndDate() != null) {
            dueEndDate = filteredList.get(0).getDueEndDate().toString();
        }

        return ReportPreviewDTO.builder()
                .companyName(companyInfo)
                .issuedDate(issuedDate)
                .dueEndDate(dueEndDate)
                .selectedTimes(times)
                .totalCount(totalCount)
                .totalCarbonAbsorption(totalCarbonAbsorption)
                .certGrade(certGrade)
                .speciesDetail( speciesDetails )
                .build();
    }
}
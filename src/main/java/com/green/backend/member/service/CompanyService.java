package com.green.backend.member.service;

import com.green.backend.FileService;
import com.green.backend.member.dto.BusinessDto;
import com.green.backend.member.dto.CompanyDTO;
import com.green.backend.member.dto.CompanyResponseDTO;
import com.green.backend.member.entity.Company;
import com.green.backend.member.repository.CompanyRepository;

import com.green.backend.util.FileUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final BusinessVerifyService businessVerifyService;
    private final FileUtil fileUtil;


    // 기업등록
    public boolean companyadd(CompanyDTO companyDTO){

        // 사업자 등록 번호 인증
        BusinessDto businessDto = new BusinessDto();
        businessDto.setBusiness_number(companyDTO.getBusiness_number());
        boolean varify = businessVerifyService.verifyBusiness(businessDto.getBusiness_number().replace("-", ""));
        if (!varify){return false;}

        // 사업자등록증 저장
        String fileName = fileUtil.fileUpload(companyDTO.getBusinessFile(),true);
        if (fileName != null) { companyDTO.setBusinessLicense(fileName); }

        Company company = companyDTO.toEntity();
        companyRepository.save(company);
        return true;

    }

    // 기업 수정
    public boolean companyUpdate(Long companyId, CompanyDTO companyDTO) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("기업 없음"));

        if (companyDTO.getCompanyName() != null) { company.setCompanyName(companyDTO.getCompanyName()); }
        if (companyDTO.getCeoName() != null) { company.setCeoName(companyDTO.getCeoName()); }
        if (companyDTO.getStartDate() != null) { company.setStartDate(companyDTO.getStartDate()); }
        if (companyDTO.getAddress() != null) { company.setAddress(companyDTO.getAddress()); }

        // 1. 파일 수정
        if (companyDTO.getBusinessFile() != null && !companyDTO.getBusinessFile().isEmpty()) {
            // 1.1 기존파일삭제
            fileUtil.fileDelete(company.getBusinessLicense());
            // 1.2 새 파일 업로드
            String fileName = fileUtil.fileUpload(companyDTO.getBusinessFile(), true);
            company.setBusinessLicense(fileName);
        }

        return true;
    }


    // 기업 삭제
    public boolean companyDelete(Long companyId) {
        if (!companyRepository.existsById(companyId)) { return false; }
        companyRepository.deleteById(companyId);
        return true;
    }

    // 기업 단건 조회
    public CompanyResponseDTO companyInfo(Long companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("기업 없음"));

        return CompanyResponseDTO.builder()
                .companyId(company.getCompanyId())
                .companyName(company.getCompanyName())
                .business_number(company.getBusinessNumber())
                .ceoName(company.getCeoName())
                .startDate(company.getStartDate())
                .address(company.getAddress())
                .businessLicense(company.getBusinessLicense())
                .build();
    }
    // 기업 목록 조회
    public List<CompanyResponseDTO> companyList() {
        return companyRepository.findAll().stream()
                .map(c -> CompanyResponseDTO.builder()
                        .companyId(c.getCompanyId())
                        .companyName(c.getCompanyName())
                        .business_number(c.getBusinessNumber())
                        .ceoName(c.getCeoName())
                        .startDate(c.getStartDate())
                        .address(c.getAddress())
                        .businessLicense(c.getBusinessLicense())
                        .isApproved(c.getIsApproved())
                        .build())
                .collect(Collectors.toList());
    }

    //





}

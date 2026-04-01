package com.green.backend.member.service;

import com.green.backend.FileService;
import com.green.backend.member.dto.BusinessDto;
import com.green.backend.member.dto.CompanyDTO;
import com.green.backend.member.dto.CompanyResponseDTO;
import com.green.backend.member.entity.Company;
import com.green.backend.member.repository.CompanyRepository;

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
    private final FileService fileService;


    // 기업등록
    public boolean companyadd(CompanyDTO companyDTO){

        // 사업자 등록 번호 인증
        BusinessDto businessDto = new BusinessDto();
        businessDto.setBusiness_number(companyDTO.getBusiness_number());
        boolean varify = businessVerifyService.verifyBusiness(businessDto.getBusiness_number());
        if (!varify){return false;}

        // 사업자등록증 저장
        String fileName = fileService.saveFile(companyDTO.getBusinessFile());
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

        // 파일 수정
        String fileName = fileService.saveFile(companyDTO.getBusinessFile());
        if (fileName != null) { company.setBusinessLicense(fileName); }

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
                .business_number(company.getBusiness_number())
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
                        .business_number(c.getBusiness_number())
                        .ceoName(c.getCeoName())
                        .startDate(c.getStartDate())
                        .address(c.getAddress())
                        .businessLicense(c.getBusinessLicense())
                        .build())
                .collect(Collectors.toList());
    }





}

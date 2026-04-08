package com.green.backend.member.dto;

import com.green.backend.member.entity.Company;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class CompanyDTO {
    private String companyName;
    private String business_number;
    private String businessLicense;        // DB용
    private MultipartFile businessFile;    // 업로드용

    private String ceoName;    // 대표자
    private String startDate;  // 개업년월일
    private String address;    // 소재지

    private int isApproved; // 승인상태

    public Company toEntity() {
        return Company.builder()
                .companyName(companyName)
                .businessNumber(business_number)
                .businessLicense(businessLicense)
                .ceoName(ceoName)
                .startDate(startDate)
                .address(address)
                .build();
    }
}

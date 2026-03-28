package com.green.backend.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyResponseDTO {
    private Long companyId;
    private String companyName;
    private String business_number;
    private String ceoName;
    private String startDate;
    private String address;
    private String businessLicense;
}

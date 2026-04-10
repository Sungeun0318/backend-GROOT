package com.green.backend.member.entity;


import com.green.backend.BaseTime;
import com.green.backend.member.dto.CompanyResponseDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder@Table(name = "company")
public class Company extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long companyId;

    @Column(nullable = false,length = 30)
    private String companyName; // 법인명

    @Column(nullable = false, length = 30,unique = true)
    private String businessNumber; // 사업자등록번호

    @Column(length = 50)
    private String ceoName;      // 대표자

    @Column(length = 20)
    private String startDate;    // 개업년월일

    @Column(length = 200)
    private String address;      // 소재지

    @Column(name = "is_approved")
    private int isApproved; // 0: 대기, 1: 승인, 2: 거절

    @Column(name = "business_license")
    private String businessLicense; // 사업자등록증(이미지)

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", orphanRemoval = true)
    @Builder.Default
    @ToString.Exclude
    private List<Member> members = new ArrayList<>();

    public CompanyResponseDTO toDTO() {
        return CompanyResponseDTO.builder()
                .companyId(companyId)
                .companyName(companyName)
                .business_number(businessNumber)
                .ceoName(ceoName)
                .startDate(startDate)
                .address(address)
                .businessLicense(businessLicense)
                .createDate(getCreateDate().toString())
                .isApproved(isApproved)
                .build();
    }




}
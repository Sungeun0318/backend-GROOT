package com.green.backend.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class MemberResponseDTO {
    private Long mid;
    private String mname; // 아이디
    private String email; // 이메일
    private String address; // 주소
    private String party_name; // 당담자이름
    private String company_number; // 전화번호
    private String careerFile; // 경력증명서
    private int isApproved; // 승인상태
    private int isAdmin; // 회원등급
    private String createDate;


    // 기업 정보
    private String companyName;
    private String business_number;
    private String ceoName;
    private String startDate;
    private String companyAddress;
    private String businessLicense;


}

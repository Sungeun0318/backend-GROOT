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
    private String mname;
    private String email;
    private String address;
    private String party_name;
    private String company_number;
    private String mfile; // 프로필
    private String careerFile; // 추가
    private int isApproved; // 승인상태
    private int isAdmin; // 회원등급
}

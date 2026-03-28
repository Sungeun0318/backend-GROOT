package com.green.backend.member.dto;

import com.green.backend.member.entity.Company;
import com.green.backend.member.entity.Member;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@ToString@AllArgsConstructor
@Builder
public class MemberDTO {

    private Long mid;
    private Long company_id;
    private String mname;
    private String password;
    private String party_name;
    private String company_number;
    private String email;
    private String address;
    // 프로필
    private String mfile;               // 디비 용도
    private MultipartFile image;        // 업로드 용도
    // pdf
    private String careerFile;          // DB용
    private MultipartFile careerPdf;    // 업로드용


    // dto --> entity
    public Member toEntity(Company company){
        return Member
                .builder()
                .company(company)
                .mname(mname)
                .party_name(party_name)
                .company_number(company_number)
                .password(password)
                .email(email)
                .address(address)
                .mfile(mfile) // image
                .careerFile(careerFile)
                .build();
    }



}

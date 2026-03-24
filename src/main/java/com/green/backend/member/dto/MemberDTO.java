package com.green.backend.member.dto;

import com.green.backend.member.entity.Company;
import com.green.backend.member.entity.Member;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class MemberDTO {

    private Long member_id;
    private Long company_id;
    private String memberName;
    private String password;
    private String party_name;
    private String company_number;
    private String email;
    private String address;

    // dto --> entity
    public Member toEntity(Company company){
        return Member
                .builder()
                .company(company)
                .memberName(memberName)
                .party_name(party_name)
                .company_number(company_number)
                .password(password)
                .email(email)
                .address(address)
                .build();
    }



}

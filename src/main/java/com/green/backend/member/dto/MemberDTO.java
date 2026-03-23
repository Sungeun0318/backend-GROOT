package com.green.backend.member.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO {

    private Long member_id;
    private String login_id;
    private String password;
    private String party_name;
    private String phone_number;
    private String email;
    private String address;
    private Integer company_id;

}

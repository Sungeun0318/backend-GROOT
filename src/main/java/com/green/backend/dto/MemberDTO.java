package com.green.backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO {

    private Long id;
    private String companyName;
    private String businessNumber;
    private String managerName;
    private String managerPhone;
    private String email;
    private String password;
}

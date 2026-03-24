package com.green.backend.member.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginResponseDTO {
    private String token;
    private Long member_id;
    private String member_name;
}

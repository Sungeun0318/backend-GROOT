package com.green.backend.member.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginTokenDTO {

    private Long mid;
    private int isAdmin;
}

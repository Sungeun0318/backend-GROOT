package com.green.backend.expertreport.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class SendLinkDto {

    private String email;
    private Long detailId;
    private String expertName;
}

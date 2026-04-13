package com.green.backend.expertreport.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TempSaveDto {

    private Long detailId;
    private String opinion;
    private String sitePicture;
    private String tempData;
}

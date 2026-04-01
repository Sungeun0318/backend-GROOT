package com.green.backend.carbon.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecentApplicationDTO {
    private Long id;
    private String species;
    private int qty;
    private String date;
    private String status;
}

package com.green.backend.carbon.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpeciesDistributionDTO {
    private String name;
    private int count;
    private int ratio;
}

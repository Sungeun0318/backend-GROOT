package com.green.backend.report.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpeciesDetailDTO {
    private String treeType;
    private int count;
    private double carbonAbsorption;
    private double ratio;
}

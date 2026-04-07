package com.green.backend.report.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public interface ReportDto {

    String getTreeType();
    int getTimes();
}

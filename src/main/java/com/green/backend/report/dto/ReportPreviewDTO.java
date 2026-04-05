package com.green.backend.report.dto;

import com.green.backend.carbon.dto.YearlyPredictionDTO;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportPreviewDTO {
    // 기업 정보
    private String companyName;
    private String partyName;
    private String issuedDate ;              // "가입일 ~ 현재"

    // 탄소흡수 요약
    private int treeCount;
    private double totalCarbonAbsorption;
    private String certGrade;

    // 수종별 상세
    private List<SpeciesDetailDTO> speciesDetail;

    /*
    // 답사 이력 ??
    private List<SurveyHistoryDTO> surveyHistory;

    // 년별 예측 ??
    private List<YearlyPredictionDTO> yearlyPredictions;

    // 계산 근거 ??
    private String calcBasis;
    */
}

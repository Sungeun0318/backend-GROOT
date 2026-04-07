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
    private String companyName;     // 기업테이블 - 회사명



    private String issuedDate ;              // 인증테이블 - 발급일
    private String startDate;                // 시작날짜 ( 발급일 -365일 )
    private int totalCount;

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

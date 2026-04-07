package com.green.backend.tree.dto;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TreeRecommendResponseDTO {

    private SoilDTO soilInfo;                          // 조회된 토양 정보
    private int maxTreesByArea;                        // 면적 기준 최대 식재 가능 수
    private List<RecommendedTree> recommendations;     // 추천 나무 리스트 (2~3종)

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class RecommendedTree {
        private String treeType;               // 수종명
        private String scientificName;         // 학명
        private String category;               // 분류 (침엽수/낙엽활엽수/상록활엽수)
        private double totalScore;             // 총점 (100점 만점)
        private double soilScore;              // 토양적합도 점수
        private double carbonScore;            // 탄소흡수력 점수
        private double weatherScore;           // 날씨적합도 점수
        private double areaScore;              // 면적적합도 점수
        private double estimatedCarbonPerYear; // 예상 연간 탄소흡수량 (kg/그루)
        private double estimatedTotalCarbon;   // 희망수량 기준 총 예상 흡수량 (kg/년)
        private double spacingMeter;           // 식재 간격 (m)
        private String reason;                 // 추천 사유
    }
}

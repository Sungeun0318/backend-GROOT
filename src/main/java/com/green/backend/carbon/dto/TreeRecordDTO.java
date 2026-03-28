package com.green.backend.carbon.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TreeRecordDTO {

    private Long recordId;                 // 나무기록번호
    private String treeType;               // 수종명 (소나무, 느티나무 등 / 5종)
    private double dbh;                    // 흉고직경 (cm)
    private double height;                 // 수고 (m)
    private double crownWidth;             // 수관폭 (m)
    private String condition;              // 상태 (생존/죽음)
    private String photoUrl;               // 사진 URL

    // 계산 결과
    private double co2Stored;              // 현재 CO2 저장량 (kg)
    private double annualAbsorption;       // 연간 흡수량 (kg)
    private int estimatedAge;              // 추정 수령 (년)
}

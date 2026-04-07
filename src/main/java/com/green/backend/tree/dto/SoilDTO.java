package com.green.backend.tree.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SoilDTO {

    private String pnuCode;            // 지번코드

    private Integer drainageGrade;     // 배수등급코드 (Soildra_Cd) 1:매우양호 2:양호 3:약간양호 4:약간불량 5:불량 6:매우불량
    private Integer effectiveDepth;    // 유효토심코드 (Vldsoildep_Cd) 1:심 2:보통 3:천
    private Integer surfaceTexture;    // 표토토성코드 (Surtture_Cd) 1:사토 2:사양토 3:양토 4:미사질양토 5:식양토 6:식토
    private Integer gravelContent;     // 표토자갈함량코드 (Sur_Ston_Cd) 1:없음 2:약간 3:있음 4:많음
    private Integer erosionGrade;      // 침식등급코드 (Erosion_Cd) 1:없음 2:약간 3:보통 4:심함
    private Integer forestSuitability; // 임지적성등급코드 (Frst_Grd_Cd) 1:1급지 2:2급지 3:3급지
    private Integer forestFactor;      // 임지저해요인코드 (Forest_Factor_Cd)
    private Integer soilTypeCd;        // 토양유형코드 (Soil_Type_Cd)
    private Integer slopeGrade;        // 분포지형코드 (Soil_Type_Geo_Cd)
}

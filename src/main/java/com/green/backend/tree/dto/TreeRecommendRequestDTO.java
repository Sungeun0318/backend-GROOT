package com.green.backend.tree.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TreeRecommendRequestDTO {

    private String pnuCode;        // 지번코드 (토양 API 호출용)
    private String regionName;     // 지역명 (기상청 API 호출용, 예: "서울")
    private Long memberId;         // 회원 ID
    private int quantity;          // 희망 수량
    private double area;           // 기업 면적 (m²)
}

package com.green.backend.certification.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GradeInfoDTO {
    private String name;    // 등급 이름
    private String emoji;   // 이모지
    private double minCarbon;   // 최소 탄소흡수량(kg)
    private double maxCarbon;   // 최대 탄소흡수량(kg) (-1이면 무제한)
    private String carbon;  // 탄소 기준 텍스트
}

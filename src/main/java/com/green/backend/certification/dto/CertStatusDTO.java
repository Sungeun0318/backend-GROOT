package com.green.backend.certification.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CertStatusDTO {
    private String grade;           // 현재 등급 (씨앗/새싹/숲/산림)
    private int treeCount;          // 등록 수목 수
    private double totalCarbonAbsorption; // 탄소흡수량
    private LocalDateTime expireDate;     // 유효기간
    private double carbonUntilNext;  // 다음 등급까지 남은 탄소흡수량(kg)
    private String nextGrade;       // 다음 등급 이름
    private int currentGradeIndex;  // 현재 등급 인덱스 (0~3)
    private double progress;        // 현재 등급 내 진행률 (0~100)
}

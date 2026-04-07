package com.green.backend.tree.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "tree_coefficient")
public class TreeCoefficient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int coefficientId;         // 계수번호 (PK)

    @Column(nullable = false, unique = true, length = 30)
    private String treeType;           // 수종명 (예: 강원지방소나무, 잣나무)

    @Column(length = 60)
    private String scientificName;     // 학명

    @Column(nullable = false, length = 10)
    private String category;           // 분류: 침엽수, 낙엽활엽수, 상록활엽수

    @Column(nullable = false)
    private double factorA;            // 상대생장식 계수 a (y = a * D^b)

    @Column(nullable = false)
    private double factorB;            // 상대생장식 계수 b

    @Column(nullable = false)
    private double annualGrowth;       // 연평균 DBH 성장률 (cm/년)

    @Column(nullable = false)
    private double rootRatio;          // 뿌리함량비 (R)

    private Double woodDensity;        // 목재기본밀도 (D, ton/m³)

    private Double bef;                // 바이오매스 확장계수 (BEF)

    private Integer dbhMin;            // 식 사용범위 최소 DBH (cm)

    private Integer dbhMax;            // 식 사용범위 최대 DBH (cm)

    // ===== 추천 알고리즘용 토양 선호도 =====

    private Integer preferredDrainageMin;  // 선호 배수등급 최소 (1매우양호~6매우불량)
    private Integer preferredDrainageMax;  // 선호 배수등급 최대

    private Integer preferredDepthMin;     // 선호 유효토심 (1심~3천), 최소(좋은쪽)
    private Integer preferredDepthMax;     // 선호 유효토심 최대(허용한계)

    private Integer preferredTextureMin;   // 선호 표토토성 최소 (1사토~6식토)
    private Integer preferredTextureMax;   // 선호 표토토성 최대

    @Column(columnDefinition = "double default 3.0")
    private double spacingMeter;           // 식재 간격 (m) → 면적÷간격²=수용가능수

    @Column(columnDefinition = "int default 2")
    private int maintenanceLevel;          // 관리 난이도 (1쉬움 2보통 3어려움)

    @Column(columnDefinition = "int default 3")
    private int aestheticScore;            // 미관 점수 (1~5)
}

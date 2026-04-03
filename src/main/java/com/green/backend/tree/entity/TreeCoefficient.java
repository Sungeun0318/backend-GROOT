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
}

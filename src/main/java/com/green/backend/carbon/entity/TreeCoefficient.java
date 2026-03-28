package com.green.backend.carbon.entity;

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

    @Column(nullable = false, unique = true, length = 20)
    private String treeType;           // 수종명 (침엽수/활엽수)

    @Column(nullable = false)
    private double factorA;            // 상대생장식 계수 a

    @Column(nullable = false)
    private double factorB;            // 상대생장식 계수 b

    @Column(nullable = false)
    private double annualGrowth;       // 연평균 DBH 성장률 (cm/년)

    @Column(nullable = false, columnDefinition = "double default 0.25")
    private double rootRatio;          // 뿌리 바이오매스 비율

    private Double woodDensity;        // 목재 기본밀도 (ton/m3)
}

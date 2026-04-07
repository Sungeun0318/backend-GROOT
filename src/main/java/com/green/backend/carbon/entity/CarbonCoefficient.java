package com.green.backend.carbon.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "carbon_coefficient")
public class CarbonCoefficient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int coefficientId;         // 계수번호 (PK)

    @Column(nullable = false, unique = true, length = 10)
    private String treeType;           // 분류: 침엽수, 활엽수

    @Column(nullable = false)
    private double factorA;            // 상대생장식 계수 a (W = a × D^b)

    @Column(nullable = false)
    private double factorB;            // 상대생장식 계수 b

    @Column(nullable = false)
    private double annualGrowth;       // 연평균 DBH 성장률 (cm/년)

    @Column(nullable = false)
    private double rootRatio;          // 뿌리함량비 (R)

    private Double woodDensity;        // 목재기본밀도 (D, ton/m³)

    private Double bef;                // 바이오매스 확장계수 (BEF)
}

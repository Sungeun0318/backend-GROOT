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
    private Long id;

    @Column(nullable = false, length = 50)
    private String treeName;            // 수종명 (소나무, 잣나무, 침엽수 기본, 활엽수 기본...)

    @Column(nullable = false, length = 20)
    private String treeType;            // CONIFER(침엽수) / BROADLEAF(활엽수)

    // 상대생장식 계수: W = a × (DBH² × H)^b
    @Column(nullable = false)
    private double aValue;              // 상대생장식 a

    @Column(nullable = false)
    private double bValue;              // 상대생장식 b

    // 바이오매스 변환 계수
    @Column(nullable = false)
    private double density;             // 목재기본밀도 D (t/m³)

    @Column(nullable = false)
    private double bef;                 // 바이오매스확장계수 BEF

    @Column(nullable = false)
    private double rootRatio;           // 뿌리함량비 R

    @Column(nullable = false)
    private double carbonFraction;      // 탄소전환계수 CF (침엽수 0.51, 활엽수 0.48)

    // 수령 추정 계수: age = c × DBH^d
    @Column(nullable = false)
    private double ageCValue;           // 수령 추정 c

    @Column(nullable = false)
    private double ageDValue;           // 수령 추정 d

    // 연간 성장량
    @Column(nullable = false)
    private double dbhGrowth;           // 연간 DBH 성장량 (cm/년)

    @Column(nullable = false)
    private double heightGrowth;        // 연간 수고 성장량 (m/년)

    @Column(nullable = false)
    private boolean isDefault;          // 통합 기본값 여부 (true = 수종 못 찾을 때 사용)
}

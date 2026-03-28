package com.green.backend.carbon.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "regional_emission")
public class RegionalEmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emissionId;            // 배출량번호 (PK)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", nullable = false)
    private RegionCode regionCode;     // 지역 FK

    @Column(nullable = false)
    private int year;                  // 연도

    @Column(nullable = false)
    private double totalEmission;      // 총 온실가스 배출량 (tCO2eq)
}

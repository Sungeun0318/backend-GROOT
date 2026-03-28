package com.green.backend.carbon.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "region_code")
public class RegionCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int regionId;              // 지역번호 (PK)

    @Column(nullable = false, unique = true, length = 30)
    private String regionName;         // 시도명

    @Column(nullable = false)
    private int nx;                    // 기상청 격자 X좌표

    @Column(nullable = false)
    private int ny;                    // 기상청 격자 Y좌표
}

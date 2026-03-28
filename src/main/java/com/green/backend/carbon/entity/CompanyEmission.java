package com.green.backend.carbon.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "company_emission")
public class CompanyEmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int companyEmissionId;     // 배출량번호 (PK)

    @Column(nullable = false, length = 100)
    private String companyName;        // 법인명

    @Column(nullable = false)
    private double companyEmission;    // 총 온실가스 배출량
}

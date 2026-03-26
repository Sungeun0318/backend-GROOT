package com.green.backend.carbon.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "company_emission")
public class CompanyEmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String companyName;

    @Column(nullable = false)
    private int targetYear;

    @Column(length = 20)
    private String designation;

    @Column(length = 200)
    private String industryType;

    @Column(nullable = false)
    private double emissionAmount;

    @Column(nullable = false)
    private double energyUsage;
}

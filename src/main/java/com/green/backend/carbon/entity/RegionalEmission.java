package com.green.backend.carbon.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "regional_emission")
public class RegionalEmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", nullable = false)
    private RegionCode regionCode;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private double emissionTotal;
}

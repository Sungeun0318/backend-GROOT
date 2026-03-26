package com.green.backend.carbon.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "region_code")
public class RegionCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regionId;

    @Column(nullable = false, length = 20)
    private String regionName;

    @Column(nullable = false)
    private int nx;

    @Column(nullable = false)
    private int ny;

    @Column(nullable = false)
    private int kosisBlockIndex;
}

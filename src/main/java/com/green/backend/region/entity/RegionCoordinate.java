package com.green.backend.region.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "region_coordinate")
public class RegionCoordinate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String city; // 시/도 단위 (서울, 부산, 수원, 성남 등)

    @Column(nullable = false, length = 30)
    private String district; // 구/군 단위 (강남구, 해운대구, 영통구 등)

    @Column(nullable = false)
    private double latitude; // 위도

    @Column(nullable = false)
    private double longitude; // 경도
}

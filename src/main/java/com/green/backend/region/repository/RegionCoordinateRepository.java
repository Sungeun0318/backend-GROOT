package com.green.backend.region.repository;

import com.green.backend.region.entity.RegionCoordinate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionCoordinateRepository extends JpaRepository<RegionCoordinate, Long> {

    // 시 이름으로 좌표 조회 (예: "서울", "수원")
    List<RegionCoordinate> findByCity(String city);

    // 시 + 구 이름으로 좌표 조회
    RegionCoordinate findByCityAndDistrict(String city, String district);
}

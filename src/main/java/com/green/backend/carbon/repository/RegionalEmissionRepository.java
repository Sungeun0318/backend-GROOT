package com.green.backend.carbon.repository;

import com.green.backend.carbon.entity.RegionalEmission;
import com.green.backend.carbon.entity.RegionCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RegionalEmissionRepository extends JpaRepository<RegionalEmission, Long> {

    List<RegionalEmission> findByYear(int year);

    List<RegionalEmission> findByRegionCode(RegionCode regionCode);

    Optional<RegionalEmission> findByRegionCodeAndYear(RegionCode regionCode, int year);
}

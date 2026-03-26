package com.green.backend.carbon.repository;

import com.green.backend.carbon.entity.RegionCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionCodeRepository extends JpaRepository<RegionCode, Long> {

    Optional<RegionCode> findByRegionName(String regionName);

    Optional<RegionCode> findByKosisBlockIndex(int kosisBlockIndex);
}

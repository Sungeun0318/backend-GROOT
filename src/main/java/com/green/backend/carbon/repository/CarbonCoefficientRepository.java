package com.green.backend.carbon.repository;

import com.green.backend.carbon.entity.CarbonCoefficient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarbonCoefficientRepository extends JpaRepository<CarbonCoefficient, Integer> {

    Optional<CarbonCoefficient> findByTreeType(String treeType);
}

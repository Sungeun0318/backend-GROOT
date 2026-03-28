package com.green.backend.carbon.repository;

import com.green.backend.carbon.entity.TreeCoefficient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TreeCoefficientRepository extends JpaRepository<TreeCoefficient, Integer> {

    // 수종명으로 계수 조회 (침엽수/활엽수)
    Optional<TreeCoefficient> findByTreeType(String treeType);
}

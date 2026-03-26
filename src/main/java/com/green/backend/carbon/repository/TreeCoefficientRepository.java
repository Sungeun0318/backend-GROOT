package com.green.backend.carbon.repository;

import com.green.backend.carbon.entity.TreeCoefficient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TreeCoefficientRepository extends JpaRepository<TreeCoefficient, Long> {

    // 수종명으로 개별 계수 조회
    Optional<TreeCoefficient> findByTreeName(String treeName);

    // 수종 못 찾을 때 → 침엽수/활엽수 통합 기본값 조회
    Optional<TreeCoefficient> findByTreeTypeAndIsDefaultTrue(String treeType);
}

package com.green.backend.tree.repository;

import com.green.backend.tree.entity.TreeCoefficient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TreeCoefficientRepository extends JpaRepository<TreeCoefficient, Integer> {

    // 수종명으로 계수 조회
    Optional<TreeCoefficient> findByTreeType(String treeType);

    // 분류별 조회 (침엽수, 낙엽활엽수, 상록활엽수)
    List<TreeCoefficient> findByCategory(String category);
}

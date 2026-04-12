package com.green.backend.expert.repository;

import com.green.backend.expert.entity.Expert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpertRepository extends JpaRepository<Expert, Long> {

    // 상태별 전문가 조회 (예: "가용")
    List<Expert> findByExpertState(String expertState);
}

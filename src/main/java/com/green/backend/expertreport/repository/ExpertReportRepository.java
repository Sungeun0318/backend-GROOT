package com.green.backend.expertreport.repository;

import com.green.backend.application.entity.Application;
import com.green.backend.expertreport.entity.ExpertReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpertReportRepository extends JpaRepository<ExpertReport, Long> {

    // 답사별 나무기록 전체 조회 (CarbonCalculator에서 사용)
    List<ExpertReport> findAllByApplication(Application application);
}

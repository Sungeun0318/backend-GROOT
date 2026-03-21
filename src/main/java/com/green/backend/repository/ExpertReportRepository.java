package com.green.backend.repository;

import com.green.backend.entity.ExpertReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertReportRepository extends JpaRepository<ExpertReport, Long> {
}

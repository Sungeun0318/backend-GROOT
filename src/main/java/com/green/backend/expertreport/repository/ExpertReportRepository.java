package com.green.backend.expertreport.repository;

import com.green.backend.expertreport.entity.ExpertReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpertReportRepository extends JpaRepository<ExpertReport, Long> {

    List<ExpertReport> findByApplication_DetailId(Long detailId);
}

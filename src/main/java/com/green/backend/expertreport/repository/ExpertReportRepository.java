package com.green.backend.expertreport.repository;

import com.green.backend.application.entity.Application;
import com.green.backend.expertreport.dto.TreeDto;
import com.green.backend.expertreport.dto.basicReportDto;
import com.green.backend.expertreport.entity.ExpertReport;
import com.green.backend.kakaomap.dto.KakaomapDto;
import com.green.backend.kakaomap.dto.treeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpertReportRepository extends JpaRepository<ExpertReport, Long> {

    // 답사별 나무기록 전체 조회 (CarbonCalculator에서 사용)
    List<ExpertReport> findAllByApplication(Application application);

    List<ExpertReport> findByApplication_DetailId(Long detailId);

    // 카카오맵에 사용할 기업 정보 + 나무 정보
    @Query("""
                SELECT new com.green.backend.kakaomap.dto.treeDto(
                    e.treeType,
                    e.latitude,
                    e.longitude,
                    a.times
                )
                FROM ExpertReport e
                JOIN e.application a
                JOIN a.memberId m
                WHERE m.mid = :memberId
                  AND a.times = (
                      SELECT MAX(a2.times)
                      FROM ExpertReport e2
                      JOIN e2.application a2
                      JOIN a2.memberId m2
                      WHERE m2.mid = :memberId
                  )
            """)
    List<treeDto> findTreeByMemberId(@Param("memberId") Long memberId);


    // 카카오맵에 사용할 것 앤티티 가져오기
    @Query("""
    SELECT er
    FROM ExpertReport er
    JOIN FETCH er.application a
    JOIN FETCH a.memberId m
    LEFT JOIN FETCH m.company c
    WHERE m.mid = :memberId
      AND a.surveyStatus = '답사완료'
      AND a.times = (
          SELECT MAX(a2.times)
          FROM Application a2
          WHERE a2.memberId = m
            AND a2.surveyStatus = '답사완료'
      )
""")
    List<ExpertReport> findLatestReportsByMemberId(@Param("memberId") Long memberId);

    // 전문가 - 보고서 기본 정보
    @Query("""
                SELECT DISTINCT new com.green.backend.expertreport.dto.basicReportDto(
                            a.detailId,
                            a.content,
                            a.dueStartDate,
                            a.dueEndDate,
                            a.times,
                            c.companyName,
                            m.party_name,
                            m.address
                )
                FROM ExpertReport er
                JOIN er.application a
                JOIN a.memberId m
                LEFT JOIN m.company c
                WHERE a.detailId = :detailId
            """)
    basicReportDto findBasicReportByDetailId(@Param("detailId") Long detailId);

    // 기업 - 나무 정보 조회
    @Query("""
    SELECT er
    FROM ExpertReport er
    JOIN FETCH er.application a
    JOIN FETCH a.memberId m
    WHERE m.company.companyId = :companyId
      AND a.surveyStatus = '답사완료'
      AND a.times = (
          SELECT MAX(a2.times)
          FROM Application a2
          WHERE a2.memberId = m
            AND a2.surveyStatus = '답사완료'
      )
    ORDER BY m.mid ASC, er.treeId DESC
""")
    List<ExpertReport> findLatestTreeEntitiesByCompanyId(@Param("companyId") Long companyId);
}

package com.green.backend.certification.repository;

import com.green.backend.certification.entity.Certification;
import com.green.backend.kakaomap.dto.KakaomapDto;
import com.green.backend.report.dto.MemberCompanyDto;
import com.green.backend.report.dto.ReportDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificationRepository extends JpaRepository<Certification, Long> {
    Certification findByMember_Mid(Long memberId);


    @Query(value = """
    SELECT 
        e.tree_type AS treeType,
        e.kind As kind,
        a.due_end_date AS dueEndDate,
        a.times AS times,
        e.tree_id As treeId
    FROM expert_report e
    INNER JOIN application a
      ON e.detail_id = a.detail_id
    WHERE a.member_id = :memberId
    """, nativeQuery = true)
    List<ReportDto> findByMemberId(@Param("memberId") Long memberId);

    @Query(value = """
    SELECT 
        c.company_name AS companyName,
        m.party_name AS partyName
    FROM company c
    INNER JOIN member m
      ON c.company_id = m.member_id
    WHERE m.member_id = :memberId
    """, nativeQuery = true)
    List<MemberCompanyDto> findMemberCompany(@Param("memberId") Long memberId);


    @Query("""
        SELECT new com.green.backend.kakaomap.dto.KakaomapDto(
            c.grade,
            c.treeCount,
            c.totalCarbonAbsorption,
            co.companyName,
            m.party_name,
            m.address
        )
        FROM Certification c
        JOIN c.member m
        JOIN m.company co
        WHERE m.mid = :memberId
    """)
    List<KakaomapDto> findKakaomapByMemberId(@Param("memberId") Long memberId);
}

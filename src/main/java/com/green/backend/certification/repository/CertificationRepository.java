package com.green.backend.certification.repository;

import com.green.backend.certification.entity.Certification;
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
        a.times AS times
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
  

  
}

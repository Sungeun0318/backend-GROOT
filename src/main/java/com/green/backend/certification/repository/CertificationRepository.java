package com.green.backend.certification.repository;

import com.green.backend.certification.entity.Certification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificationRepository extends JpaRepository<Certification, Long> {
    Certification findByMemberId_Mid(Long memberId);
}

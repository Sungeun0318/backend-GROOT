package com.green.backend.member.repository;

import com.green.backend.member.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findByIsApproved(int isApproved);

    Optional<Company> findByBusinessNumber(String businessNumber);
}
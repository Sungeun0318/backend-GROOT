package com.green.backend.carbon.repository;

import com.green.backend.carbon.entity.CompanyEmission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyEmissionRepository extends JpaRepository<CompanyEmission, Integer> {

    List<CompanyEmission> findByCompanyNameContaining(String companyName);
}

package com.green.backend.expertreport.repository;

import com.green.backend.expertreport.entity.QrShare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QrShareRepository extends JpaRepository<QrShare, Long> {



}

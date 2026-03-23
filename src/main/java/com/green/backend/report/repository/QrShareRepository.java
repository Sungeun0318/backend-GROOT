package com.green.backend.report.repository;

import com.green.backend.report.entity.QrShare;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface QrShareRepository extends JpaRepository<QrShare, Long> {

}

package com.green.backend.repository;

import com.green.backend.entity.QrShare;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface QrShareRepository extends JpaRepository<QrShare, Long> {

}

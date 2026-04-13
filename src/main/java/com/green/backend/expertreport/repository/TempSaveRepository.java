package com.green.backend.expertreport.repository;


import com.green.backend.expertreport.entity.TempSave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface TempSaveRepository extends JpaRepository<TempSave, Long>{
    Optional<TempSave> findByApplication_DetailId(Long detailId);

    void deleteByApplication_DetailId(Long detailId);

}

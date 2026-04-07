package com.green.backend.schedule.repository;

import com.green.backend.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long>{
    // 특정 전문가의 모든 불가능 일정 조회
    List<Schedule> findByExpertId_ExpertId(Long expertId);

    // 날짜 범위 겹칠 때 해당날짜 신청 차단
    @Query("SELECT COUNT(s) >0 FROM Schedule s" +
            " WHERE s.expertId.expertId = :expertId "+
            " AND :applyDate BETWEEN s.scheduleStart AND s.scheduleEnd" )
    boolean existsConflict(
            @Param("expertId") Long expertId,
            @Param("applyDate") String applyDate
    );
}
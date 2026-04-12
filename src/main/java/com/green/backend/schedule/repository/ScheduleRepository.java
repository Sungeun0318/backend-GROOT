package com.green.backend.schedule.repository;

import com.green.backend.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long>{
    // 특정 전문가의 모든 불가능 일정 조회
    List<Schedule> findByExpertId_ExpertId(Long expertId);

    // 날짜 범위 겹칠 때 해당날짜 신청 차단
    @Query("SELECT COUNT(s) >0 FROM Schedule s" +
            " WHERE s.expertId.expertId = :expertId "+
            " AND s.scheduleStart <= :endDate" +
            " AND s.scheduleEnd >= :startDate" )
    boolean existsConflict(
            @Param("expertId") Long expertId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

    // 기업 신청 폼에 전문가 불가능한 일정 조회(월별)
    // 시작,중료 연도/월로 조회
    @Query("SELECT s FROM Schedule s " +
           "WHERE s.scheduleStart <= :monthEnd " +
            "And s.scheduleEnd >= :monthStart")
    List<Schedule> findAllSchedulesByMonth(
            @Param("monthStart") LocalDate monthStart,
            @Param("monthEnd") LocalDate monthEnd
            );

}
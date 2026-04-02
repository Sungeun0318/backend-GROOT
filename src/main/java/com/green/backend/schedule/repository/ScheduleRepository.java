package com.green.backend.schedule.repository;

import com.green.backend.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long>{
    List<Schedule> findByExpertId_ExpertId(Long expertId);
}
package com.green.backend.schedule.service;

import com.green.backend.application.entity.Application;
import com.green.backend.application.repository.ApplicationRepository;
import com.green.backend.expert.dto.ExpertDTO;
import com.green.backend.expert.entity.Expert;
import com.green.backend.expert.repository.ExpertRepository;
import com.green.backend.member.dto.LoginTokenDTO;
import com.green.backend.member.entity.Member;
import com.green.backend.schedule.dto.ScheduleDTO;
import com.green.backend.schedule.entity.Schedule;
import com.green.backend.schedule.repository.ScheduleRepository;
import com.green.backend.util.JwtUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    public final ScheduleRepository scheduleRepository;
    public final ExpertRepository expertRepository;
    public final ApplicationRepository applicationRepository;

    // (1) 전문가가 불가능한 일정 등록하기
    public ScheduleDTO enrollSchedule(ScheduleDTO scheduleDTO) {
        Expert expert = expertRepository.findById(scheduleDTO.getExpertId()).orElseThrow(() -> new RuntimeException("해당 전문가 정보가 없습니다."));
        return scheduleRepository.save(scheduleDTO.toEntity(expert)).toDto();
    }

    // (2) 개별전문가 일정목록조회
    @Transactional
    public List<ScheduleDTO> getEnrollScheduleList(Long expertId) {
        List<Schedule> schedule = scheduleRepository.findByExpertId_ExpertId(expertId);
        return schedule.stream().map(Schedule::toDto).collect(Collectors.toList());
    }

    // (3) 전문가 일정목록 전체조회
    public List<ScheduleDTO> getAllEnrollScheduleList() {
        return scheduleRepository.findAll()
                .stream()
                .map(Schedule::toDto)
                .collect(Collectors.toList());
    }

    // 전문가 상태 변경
    @Transactional
    @Scheduled(cron = "0 0 0 * * *")
    public void updateExpertStatus() {
        LocalDate today = LocalDate.now();
        List<Application> targets = applicationRepository
                .findAllBySurveyStatusAndDueStartDate("신청", today);
        if (targets.isEmpty()) return;
        for (Application app : targets) {
            app.setSurveyStatus("진행중");
            if (app.getExpertId() != null) {
                app.getExpertId().setExpertState("파견");
            }
        }
    }
}
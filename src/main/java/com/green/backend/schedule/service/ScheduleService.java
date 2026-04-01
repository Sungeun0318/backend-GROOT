package com.green.backend.schedule.service;

import com.green.backend.expert.dto.ExpertDTO;
import com.green.backend.expert.repository.ExpertRepository;
import com.green.backend.member.dto.LoginTokenDTO;
import com.green.backend.schedule.dto.ScheduleDTO;
import com.green.backend.schedule.entity.Schedule;
import com.green.backend.schedule.repository.ScheduleRepository;
import com.green.backend.util.JwtUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class ScheduleService {
    public final ScheduleRepository scheduleRepository;
    public final ExpertRepository expertRepository;

    // (1) 전문가가 불가능한 일정 등록하기
    private boolean enrollSchedule(ScheduleDTO scheduleDTO){
        try {
            if (!expertRepository.existsById(scheduleDTO.getExpertId())) {
                throw new IllegalArgumentException("존재하지 않는 ID입니다.");
            }

            if (scheduleDTO.getNotAvailable() == null || scheduleDTO.getScheduleState() == null) {
                return false;
            }
            Schedule schedule = scheduleDTO.toEntity();
            scheduleRepository.save(schedule);
            return true;
        }catch (Exception e){
            log.error("일정등록 중 오류 발생 : {} ", e.getMessage());
            return false;
        }
    }
    //


}
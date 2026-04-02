package com.green.backend.schedule.service;

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
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Transactional
@Service
@RequiredArgsConstructor
public class ScheduleService {
    public final ScheduleRepository scheduleRepository;
    public final ExpertRepository expertRepository;

    // (1) 전문가가 불가능한 일정 등록하기
    public ScheduleDTO enrollSchedule(ScheduleDTO scheduleDTO){
        Expert expert = expertRepository.findById(scheduleDTO.getExpertId()).orElseThrow(() -> new RuntimeException("해당 전문가 정보가 없습니다."));
        return scheduleRepository.save(scheduleDTO.toEntity(expert)).toDto();
    }
    // (2)


}
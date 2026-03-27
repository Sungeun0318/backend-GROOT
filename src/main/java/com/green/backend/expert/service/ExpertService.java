package com.green.backend.expert.service;


import com.green.backend.expert.dto.ExpertDTO;
import com.green.backend.expertreport.repository.ExpertReportRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@Service
@RequiredArgsConstructor
public class ExpertService {

    private final ExpertReportRepository expertReportRepository;


    public boolean createSpecialist(ExpertDTO expertDTO){

        return true; // 임시
    }
}

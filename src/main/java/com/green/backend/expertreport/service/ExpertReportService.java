package com.green.backend.expertreport.service;


import com.green.backend.application.entity.Application;
import com.green.backend.application.repository.ApplicationRepository;
import com.green.backend.expertreport.dto.ExpertReportDTO;
import com.green.backend.expertreport.entity.ExpertReport;
import com.green.backend.expertreport.repository.ExpertReportRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ExpertReportService {

    private final ExpertReportRepository expertReportRepository;
    private final ApplicationRepository applicationRepository;

    // 답사 정보 등록
    public boolean saveSurvey(List<ExpertReportDTO> dtoList) {

        // 유효성검사(등록할 정보가 없는경우)
        if (dtoList == null || dtoList.isEmpty()) {
            throw new IllegalArgumentException("저장할 테이터가 없음");
        }

        Application application = applicationRepository.findById(dtoList.get(0).getDetail_id())
                .orElseThrow(() -> new IllegalArgumentException("detail_id 없음"));

        // opinion 과 times 는 어차피 같으니 하나씩 넣고 반복
        application.setOpinion(dtoList.get(0).getOpinion());
        application.setTimes(dtoList.get(0).getTimes());

        List<ExpertReport> entityList = new ArrayList<>();

        for (ExpertReportDTO dto : dtoList) {
            ExpertReport entity = dto.toEntity();
            entity.setApplication(application);
            entityList.add(entity);
        }

        expertReportRepository.saveAll(entityList);

        return true;
    }
}


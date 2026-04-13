package com.green.backend.expertreport.service;

import com.green.backend.application.entity.Application;
import com.green.backend.application.repository.ApplicationRepository;
import com.green.backend.expertreport.dto.TempSaveDto;
import com.green.backend.expertreport.entity.TempSave;
import com.green.backend.expertreport.repository.TempSaveRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TempSaveService {

    private final TempSaveRepository tempSaveRepository;
    private final ApplicationRepository applicationRepository;

    @Transactional
    public boolean saveTemp(TempSaveDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("임시저장 데이터가 없습니다.");
        }

        if (dto.getDetailId() == null) {
            throw new IllegalArgumentException("detailId가 없습니다.");
        }

        Application application = applicationRepository.findById(dto.getDetailId())
                .orElseThrow(() -> new IllegalArgumentException("detail_id 없음"));

        if (!"답사진행중".equals(application.getSurveyStatus())) {
            throw new IllegalStateException("해당 답사는 진행중이 아닙니다.");
        }

        LocalDate now = LocalDate.now();
        LocalDate start = application.getDueStartDate();
        LocalDate end = application.getDueEndDate();

        if (start == null || end == null) {
            throw new IllegalStateException("답사 기간 정보가 없습니다.");
        }

        if (now.isBefore(start) || now.isAfter(end)) {
            throw new IllegalStateException("임시저장 가능한 기간이 아닙니다.");
        }

        TempSave tempSave = tempSaveRepository.findByApplication_DetailId(dto.getDetailId())
                .orElse(
                        TempSave.builder()
                                .application(application)
                                .build()
                );

        tempSave.setOpinion(dto.getOpinion());
        tempSave.setSitePicture(dto.getSitePicture());
        tempSave.setTempData(dto.getTempData());

        tempSaveRepository.save(tempSave);
        return true;
    }

    public TempSaveDto getTemp(Long detailId) {
        TempSave tempSave = tempSaveRepository.findByApplication_DetailId(detailId)
                .orElse(null);

        if (tempSave == null) {
            return null;
        }

        return TempSaveDto.builder()
                .detailId(tempSave.getApplication().getDetailId())
                .opinion(tempSave.getOpinion())
                .sitePicture(tempSave.getSitePicture())
                .tempData(tempSave.getTempData())
                .build();
    }

    @Transactional
    public void deleteTemp(Long detailId) {
        if (detailId == null) {
            throw new IllegalArgumentException("detailId가 없습니다.");
        }

        tempSaveRepository.deleteByApplication_DetailId(detailId);
    }
}
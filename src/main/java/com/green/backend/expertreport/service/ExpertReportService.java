package com.green.backend.expertreport.service;


import com.green.backend.FileService;
import com.green.backend.application.dto.ApplicationDTO;
import com.green.backend.application.entity.Application;
import com.green.backend.application.repository.ApplicationRepository;
import com.green.backend.expertreport.dto.ExpertReportDTO;
import com.green.backend.expertreport.entity.ExpertReport;
import com.green.backend.expertreport.repository.ExpertReportRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ExpertReportService {

    private final ExpertReportRepository expertReportRepository;
    private final ApplicationRepository applicationRepository;
    private final FileService fileService;


    // 답사 정보 등록
    public boolean saveSurvey(List<ExpertReportDTO> dtoList, List<MultipartFile> files) {

        // 저장할 데이터 및 사진 확인
        if (dtoList == null || dtoList.isEmpty()) {System.out.println("데이터 없음");return false;}
        if (files == null || files.isEmpty()) {System.out.println("사진없음");return false;}
        if (dtoList.size() != files.size()) {System.out.println("데이터 수와 사진 수 불일치");return false;}

        // 저장할 답사 신청 번호(fk) 존재여부 확인
        Long detailId = dtoList.get(0).getDetailId();
        Application application = applicationRepository.findById(detailId)
                .orElseThrow(() -> new IllegalArgumentException("detail_id 없음"));

        application.setOpinion(dtoList.get(0).getOpinion());

        List<ExpertReport> entityList = new ArrayList<>();

        // dto 크기만큼 반복해서 사진과 데이터 순서대로 저장
        for (int i = 0; i < dtoList.size(); i++) {

            ExpertReportDTO dto = dtoList.get(i);
            MultipartFile file = files.get(i);

            String fileName = fileService.saveFile(file);

            ExpertReport entity = dto.toEntity();
            entity.setApplication(application);
            entity.setPicture(fileName);

            entityList.add(entity);
        }

        expertReportRepository.saveAll(entityList);
        return true;
    }


    // 전문가 - 답사 정보 조회
    // 답사신청테이블에서 조회
    public List<ApplicationDTO> getSurvey(Long detailId) {

        // 현재 답사신청번호로 답사신청 정보 조회
        Application application = applicationRepository.findById(detailId)
                .orElseThrow(() -> new IllegalArgumentException("detail_id 없음"));

        // 조회한 답사신청 정보에서 회원번호 확인
        Long mid = application.getMemberId().getMid();

        // 같은 회원번호, 답사상태가 완료인 답사 목록 조회
        List<Application> applicationList =
                applicationRepository.findByMemberId_MidAndSurveyStatusOrderByTimesAsc(mid, "완료");

        // DTO 변환
        List<ApplicationDTO> dtoList = new ArrayList<>();

        for (Application app : applicationList) {
            ApplicationDTO dto = new ApplicationDTO();

            dto.setDetailId(app.getDetailId());
            dto.setTimes(app.getTimes());
            dto.setSurveyStatus(app.getSurveyStatus());

            dtoList.add(dto);
        }

        return dtoList;
    }

    // 상세 조회
    public List<ExpertReportDTO> getSurveyDetail(Long detailId) {

        // detailId 존재 여부
        if (!applicationRepository.existsById(detailId)) {
            throw new IllegalArgumentException("detailId 없음");
        }

        // 나무 정보 조회
        List<ExpertReport> expertReportList =
                expertReportRepository.findByApplication_DetailId(detailId);

        if (expertReportList.isEmpty()) {
            throw new IllegalArgumentException("리스트 없음");
        }

        List<ExpertReportDTO> dtoList = new ArrayList<>();

        for (ExpertReport expertReport : expertReportList) {
            dtoList.add(expertReport.toDto());
        }

        return dtoList;
    }
}



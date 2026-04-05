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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpertReportService {

    private final ExpertReportRepository expertReportRepository;
    private final ApplicationRepository applicationRepository;
    private final FileService fileService;


    // 답사 정보 등록
    @Transactional
    public boolean saveSurvey(List<ExpertReportDTO> dtoList, List<MultipartFile> files, MultipartFile site) {

        if (dtoList == null || dtoList.isEmpty()) {
            System.out.println("데이터 없음");
            return false;
        }

        if (site == null || site.isEmpty()) {
            System.out.println("대표 사진(site) 없음");
            return false;
        }

        // 현재는 선택 가능하게 처리
        if (files != null && !files.isEmpty() && dtoList.size() != files.size()) {
            System.out.println("데이터 수와 추가 사진 수 불일치");
            return false;
        }

        // detailId 확인
        Long detailId = dtoList.get(0).getDetailId();
        Application application = applicationRepository.findById(detailId)
                .orElseThrow(() -> new IllegalArgumentException("detail_id 없음"));


        application.setOpinion(dtoList.get(0).getOpinion());
        String siteFileName = fileService.saveFile(site);
        application.setSitePicture(siteFileName);   // 현장사진

        List<ExpertReport> entityList = new ArrayList<>();

        //
        for (int i = 0; i < dtoList.size(); i++) {

            ExpertReportDTO dto = dtoList.get(i);
            ExpertReport entity = dto.toEntity();

            entity.setApplication(application);

            // 추가 사진이 있으면 저장
            if (files != null && !files.isEmpty()) {
                MultipartFile file = files.get(i);

                if (file != null && !file.isEmpty()) {
                    String fileName = fileService.saveFile(file);
                    entity.setPicture(fileName);
                }
            }

            entityList.add(entity);
        }

        applicationRepository.save(application);
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


    // 답사 링크 유효 조회
    public boolean getLink(Long detailId) {

        Application application = applicationRepository.findById(detailId)
                .orElseThrow(() -> new IllegalArgumentException("detail_id 없음"));

        LocalDate now = LocalDate.now(); // 현재 시간
        LocalDate start = application.getDueStartDate(); // 시작일
        LocalDate end = application.getDueEndDate();     // 종료일
        String status = application.getSurveyStatus();   // 상태

        // 조건 검사
        // 시작일, 종료일 검사
        if (start == null || end == null) {
            return false;
        }

        if (now.isBefore(start) || now.isAfter(end) || !"진행중".equals(status)) {
            return false;

        }
        return true;

    }
}



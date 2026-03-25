package com.green.backend.expertreport.service;


import com.green.backend.application.entity.Application;
import com.green.backend.application.repository.ApplicationRepository;
import com.green.backend.expertreport.dto.ExpertReportDTO;
import com.green.backend.expertreport.entity.ExpertReport;
import com.green.backend.expertreport.repository.ExpertReportRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ExpertReportService {

    private final ExpertReportRepository expertReportRepository;
    private final ApplicationRepository applicationRepository;

    // 파일 저장 경로
    private String baseDir = System.getProperty("user.dir"); // C:\Users\이태형\OneDrive\바탕 화면\backend
    private String uploadDir = baseDir + "/build/resources/main/static/upload/"; // 상세 경로 추가

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

            String fileName = saveFile(file);

            ExpertReport entity = dto.toEntity();
            entity.setApplication(application);
            entity.setPicture(fileName);

            entityList.add(entity);
        }

        expertReportRepository.saveAll(entityList);
        return true;
    }
    private String saveFile(MultipartFile file) {

        if (file.isEmpty()) { return null; }

        File uploadPath = new File(uploadDir);

        // 경로가 없으면 파일 생성
        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }

        // 고유 번호 추가
        String uuid = UUID.randomUUID().toString();
        String originalFileName = file.getOriginalFilename();

        String fileName = uuid + "_" + originalFileName.replaceAll("_", "-");

        File saveFile = new File(uploadDir + fileName);

        try {file.transferTo(saveFile);} catch (IOException e) {throw new RuntimeException("파일 저장 실패");}

        return fileName;
    }


    // 전문가 - 답사 정보 조회
    public boolean findSurvey(int memberId){
    return true;
    }
}



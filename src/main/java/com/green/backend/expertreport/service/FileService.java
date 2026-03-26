package com.green.backend.expertreport.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class FileService {

    // 파일 저장 경로
    private String baseDir = System.getProperty("user.dir"); // C:\Users\이태형\OneDrive\바탕 화면\backend
    private String uploadDir = baseDir + "/build/resources/main/static/upload/"; // 상세 경로 추가

    public String saveFile(MultipartFile file) {

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
}

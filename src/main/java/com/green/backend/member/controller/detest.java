package com.green.backend.member.controller;

import com.green.backend.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/test")
public class detest {

    private final FileService fileService;
    private String baseDir = System.getProperty("user.dir"); // C:\Users\이태형\OneDrive\바탕 화면\backend
    private String uploadDir = baseDir + "/build/resources/main/static/upload/"; // 상세 경로 추가

    @GetMapping("/file/{fileName}")
    public ResponseEntity<?> getFile(@PathVariable String fileName) {
        byte[] fileData = fileService.getFile(fileName);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(fileData);
    }
}

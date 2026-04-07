package com.green.backend.util;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class testController {
    private final FileUtil fileUtil;


    // 암호화 업로드 테스트
    @PostMapping("/upload/secure")
    public ResponseEntity<?> uploadSecure(MultipartFile file) {
        String url = fileUtil.fileUpload(file, true);
        return ResponseEntity.ok(url);
    }

    // 일반 업로드 테스트
    @PostMapping("/upload")
    public ResponseEntity<?> upload(MultipartFile file) {
        String url = fileUtil.fileUpload(file, false);
        return ResponseEntity.ok(url);
    }

    // 암호화 다운로드 테스트
    @GetMapping("/download/secure")
    public ResponseEntity<?> downloadSecure(@RequestParam String url) {
        byte[] data = fileUtil.fileDownload(url, true);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(data);
    }

    // 일반 다운로드 테스트
    @GetMapping("/download")
    public ResponseEntity<?> download(@RequestParam String url) {
        byte[] data = fileUtil.fileDownload(url, false);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(data);
    }

    // 삭제 테스트
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam String url) {
        boolean result = fileUtil.fileDelete(url);
        return ResponseEntity.ok(result);
    }
}

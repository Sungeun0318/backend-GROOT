package com.green.backend;

import com.green.backend.util.AesUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class FileService {

    private final AesUtil aesUtil;

    // 파일 저장 경로
    private String baseDir = System.getProperty("user.dir"); // C:\Users\이태형\OneDrive\바탕 화면\backend
    private String uploadDir = baseDir + "/build/resources/main/static/upload/"; // 상세 경로 추가

    public String saveFile(MultipartFile file) {

        if (file == null || file.isEmpty()) { return null; } // null 체크 추가


        File uploadPath = new File(uploadDir);

        // 경로가 없으면 파일 생성
        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }
        try{
            // 파일 바이트 암호화
            byte[] encrypted = aesUtil.encrypt(file.getBytes());

            // 고유 번호 추가
            String uuid = UUID.randomUUID().toString();
            String originalFileName = file.getOriginalFilename();
            String fileName = null;
            if (originalFileName != null) {
                fileName = uuid + "_" + originalFileName.replaceAll("_", "-");
            }
            File saveFile = new File(uploadDir + fileName);

            // 암호화된 바이트 스트링 변환후 저장
           String encryptedStr = Base64.getEncoder().encodeToString(encrypted);

            try (FileWriter fw = new FileWriter(saveFile)) {
                fw.write(encryptedStr);
            }
            return fileName;

        }catch (Exception e){
            System.out.println("e = " + e);
            e.printStackTrace();
        }
        return null;
    }

    public byte[] getFile(String fileName){
        try{
            String encryptedStr = Files.readString(Path.of(uploadDir+fileName));
            byte[] encryptedBytes  = Base64.getDecoder().decode(encryptedStr);
            return aesUtil.decrypt(encryptedBytes);

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }


}


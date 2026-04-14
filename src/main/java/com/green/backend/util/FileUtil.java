package com.green.backend.util;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetUrlRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import java.io.InputStream;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileUtil {
    // 자동 설정된 S3Client (AWS SDK v2) 주입
    private final S3Client s3Client;
    // application.properties에서 버킷 이름 주입 (새로운 키 사용)
    @Value("${spring.cloud.aws.s3.bucket}")
    private String bucket;
    private final AesUtil aesUtil;

    /** 파일을 S3에 업로드합니다 (AWS SDK v2 사용). */
    public String fileUpload(MultipartFile multipartFile , boolean secure) {
        if (multipartFile == null || multipartFile.isEmpty()) {
            log.warn("업로드할 파일이 비어 있습니다.");
            return null;
        }
        try {
            // 암호화
            byte[] encrypted = aesUtil.encrypt(multipartFile.getBytes());
            // (*) 동일한 파일명으로 업로드할경우 삭제이 불가능하다. 해결방법 : UUID, 식별자 생성
            String uuid = UUID.randomUUID().toString();
            // (*) 공백 (+) 파일명에 _언더바가 존재하면, 언더바는 uuid와파일명 구분하는 용도
            String objectKey = uuid + "_" + multipartFile.getOriginalFilename().replaceAll("\\s", "_");

            if (secure) { // 암호화 함
                try {
                    PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                            .bucket(bucket)
                            .key(objectKey)
                            .contentType(multipartFile.getContentType())
                            .build();
                    s3Client.putObject(putObjectRequest, RequestBody.fromBytes(encrypted));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else { // 암호화 안함
                try (InputStream inputStream = multipartFile.getInputStream()) {
                    // S3에 업로드할 객체 요청 생성 (SDK v2)
                    PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                            .bucket(bucket)
                            .key(objectKey)
                            .contentType(multipartFile.getContentType())
                            //.acl(ObjectCannedACL.PUBLIC_READ) // 이 줄 삭제
                            .build();
                    // 파일 업로드 생성 (SDK v2)
                    s3Client.putObject(putObjectRequest,
                            RequestBody.fromInputStream(inputStream, multipartFile.getSize()));
                }
            }
            // 업로드된 객체의 URL 가져오기 (SDK v2)
            GetUrlRequest getUrlRequest = GetUrlRequest.builder()
                    .bucket(bucket)
                    .key(objectKey)
                    .build();
            String fileUrl = s3Client.utilities().getUrl(getUrlRequest).toString();
            return fileUrl;
        } catch (Exception e) {
            System.err.println("Unexpected error during upload: " + e.getMessage());
            return null;
        }
    }

    /**S3에서 객체(파일)을 삭제합니다 (AWS SDK v2 사용).*/
    public boolean fileDelete(String objectKey) {
        if (objectKey == null || objectKey.isBlank()) {
            log.warn("삭제할 객체 키가 null이거나 비어있습니다.");
            return false;
        }
        try {
            objectKey = objectKey.split("/")[objectKey.split("/").length-1];
            // 삭제 요청 객체 생성 (SDK v2)
            DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
                    .bucket(bucket)
                    .key(objectKey)
                    .build();
            // 객체 삭제 실행 (SDK v2)
            s3Client.deleteObject(deleteObjectRequest);
            return true;
        } catch (Exception e) {
            log.error("S3 삭제 중 예상치 못한 오류 발생 (키: {}): {}", objectKey, e.getMessage(), e);
            System.err.println("Unexpected error during delete: " + e.getMessage());
            return false;
        }
    }

    public byte[] fileDownload(String url, boolean secure) {
        if (url == null || url.isBlank()) {
            log.warn("URL이 비어 있습니다.");
            return null;
        }
        try {
            // URL에서 objectKey 추출
            String objectKey = url.split("/")[url.split("/").length - 1];

            // S3에서 다운로드
            byte[] data = s3Client.getObjectAsBytes(
                    GetObjectRequest.builder()
                            .bucket(bucket)
                            .key(objectKey)
                            .build()
            ).asByteArray();

            if (secure) {
                return aesUtil.decrypt(data); // 복호화
            }
            return data; // 원본
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

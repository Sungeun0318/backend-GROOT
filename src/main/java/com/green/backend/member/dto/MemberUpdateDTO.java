package com.green.backend.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class MemberUpdateDTO {
    private String password;
    private String address;
    private String party_name;
    private String mfile;              // 프로필 가진 DB용
    private MultipartFile image;       // 프로필 사진
    private String careerFile;         // 경력증명서 DB용
    private MultipartFile careerPdf;   // 경력증명서 업로드용
}
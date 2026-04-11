package com.green.backend.expertreport.dto;


import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TreeDto {

    private Long treeId;    // 나무 번호
    private String treeType;    // 수종
    private String treeStatus;  // 건강 상태
    private String kind;        // 수종 구분 (침엽수, 활엽수)
    private LocalDate createDate;  // 등록 날짜

    // member 테이블
    private String address;     // member의 주소
}

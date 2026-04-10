package com.green.backend.kakaomap.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class treeDto {

    // 나무 테이블
    private String treeType;
    private double latitude;
    private double longitude;

    // 답사 테이블
    private int times;

}

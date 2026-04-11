package com.green.backend.expertreport.dto;

import com.green.backend.expertreport.entity.ExpertReport;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ExpertReportDTO {

    private Long treeId;
    private Long detailId;
    private String treeType;    // 수종
    private int dbh;        // 흉고직경
    private String treeStatus;  // 건강 상태
    private String picture; // 나무 사진
    private int height;     // 수고
    private int width;  //   수관폭
    private String kind;        // 수종 구분 (침엽수, 활엽수)

    // 위도, 경도
    private double latitude;
    private double longitude;

    // fk꺼 어떤거 넣을지 생각

    private String opinion; // 종합의견
    private Integer memberId;   // 회원번호(fk)
    private String sitePicture; // 현장사진
    private String surveyStatus;    // 답사 상태

    private String createDate;
    private String updateDate;

    public ExpertReport toEntity() {
        return ExpertReport.builder()
                .treeType(treeType)
                .dbh(dbh)
                .treeStatus(treeStatus)
                .picture(picture)
                .height(height)
                .width(width)
                .kind(kind)
                .latitude(latitude)
                .longitude(longitude).build();
    }
}

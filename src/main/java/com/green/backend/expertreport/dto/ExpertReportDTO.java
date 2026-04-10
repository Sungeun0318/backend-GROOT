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
    private String treeType;
    private int dbh;
    private String treeStatus;
    private String picture;
    private int height;
    private int width;
    private String kind;

    // 위도, 경도
    private double latitude;
    private double longitude;

    // fk꺼 어떤거 넣을지 생각

    private String opinion; // 종합의견
    private int memberId;   // 회원번호(fk)
    private String sitePicture; // 현장사진

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

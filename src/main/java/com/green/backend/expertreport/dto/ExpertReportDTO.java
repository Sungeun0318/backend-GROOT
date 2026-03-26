package com.green.backend.expertreport.dto;

import com.green.backend.expertreport.entity.ExpertReport;
import lombok.*;

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

    // fk꺼 어떤거 넣을지 생각

    private String opinion;
    private int memberId;   // 회원번호(fk)

    private String createDate;
    private String updateDate;

    public ExpertReport toEntity(){
        return ExpertReport.builder()
                //.tree_id(tree_id)
                //.application()
                .treeType(treeType)
                .dbh(dbh)
                .treeStatus(treeStatus)
                .picture(picture)
                .height(height)
                .width(width).build();
    }
}

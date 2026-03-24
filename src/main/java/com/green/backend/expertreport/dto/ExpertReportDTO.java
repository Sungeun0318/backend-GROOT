package com.green.backend.expertreport.dto;

import com.green.backend.expertreport.entity.ExpertReport;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ExpertReportDTO {

    private int tree_id;
    private Long detail_id;
    private String tree_type;
    private int dbh;
    private String tree_status;
    private String picture;
    private int height;
    private int width;

    // fk꺼 어떤거 넣을지 생각

    private String opinion;
    private int times;

    private String createDate;
    private String updateDate;

    public ExpertReport toEntity(){
        return ExpertReport.builder()
                //.tree_id(tree_id)
                //.application()
                .tree_type(tree_type)
                .dbh(dbh)
                .tree_status(tree_status)
                .picture(picture)
                .height(height)
                .width(width).build();
    }
}

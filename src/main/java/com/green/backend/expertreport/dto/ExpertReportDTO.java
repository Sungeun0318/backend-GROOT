package com.green.backend.expertreport.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ExpertReportDTO {

    private int tree_id;
    private int detail_id;
    private String tree_type;
    private int dbh;
    private String tree_status;
    private String picture;
    private int height;
    private int width;
}

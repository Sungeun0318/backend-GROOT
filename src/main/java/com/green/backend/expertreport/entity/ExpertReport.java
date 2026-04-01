package com.green.backend.expertreport.entity;

import com.green.backend.BaseTime;
import com.green.backend.application.entity.Application;
import com.green.backend.expert.entity.Expert;
import com.green.backend.expertreport.dto.ExpertReportDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpertReport extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long treeId;

    //fk
    @ManyToOne( cascade = CascadeType.ALL , fetch = FetchType.LAZY )
    @JoinColumn(name = "detailId")
    private Application application;

    @Column( nullable = false, length = 20)
    private String treeType;

    @Column(nullable = false)
    private int dbh;

    @Column(nullable = false)
    private String treeStatus;

    @Column(columnDefinition = "LONGTEXT")
    private String picture;

    @Column(nullable = false)
    private int height;

    @Column(nullable = false)
    private int width;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    public ExpertReportDTO toDto(){
        return ExpertReportDTO.builder()
                //.treeId()
                .detailId(application.getDetailId())
                .treeType(treeType)
                .dbh(dbh)
                .treeStatus(treeStatus)
                .picture(picture)
                .height(height)
                .width(width)
                .latitude(latitude)
                .longitude(longitude)
                .createDate(getCreateDate().toString())
                .updateDate(getUpdateDate().toString())
                .build();
    }
}

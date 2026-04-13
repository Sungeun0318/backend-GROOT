package com.green.backend.expertreport.entity;


import com.green.backend.BaseTime;
import com.green.backend.application.entity.Application;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TempSave extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tempId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detailId", nullable = false, unique = true)
    private Application application;

    @Column(columnDefinition = "LONGTEXT")
    private String opinion;

    @Column(columnDefinition = "LONGTEXT")
    private String sitePicture;

    @Column(columnDefinition = "LONGTEXT")
    private String tempData; // measurements 배열 전체를 JSON 문자열로 저장
}

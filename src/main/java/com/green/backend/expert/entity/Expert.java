package com.green.backend.expert.entity;

import com.green.backend.BaseTime;
import com.green.backend.application.dto.ApplicationDTO;
import com.green.backend.expert.dto.ExpertDTO;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Table( name = "expert")
public class Expert extends BaseTime {
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY )
    @Column( nullable = false, unique = true )
    private Long expertId; // 전문가번호 pk

    @Column( nullable = false, length = 30)
    private String expertName; // 이름

    @Column( nullable = false, length = 30, unique = true)
    private String expertNumber; // 연락처

    @Column( nullable = false, length = 30)
    private String expertEmail; // 이메일

    @Column( nullable = false, length = 30, columnDefinition = "VARCHAR(30) DEFAULT '가용'")
    private String expertState; // 상태

    @Column( nullable = false, length = 100, unique = true )
    private String sAddress; // 주소

    public ExpertDTO toDto(){
        return ExpertDTO.builder()
                .expertId(expertId)
                .expertName(expertName)
                .expertNumber(expertNumber)
                .expertEmail(expertEmail)
                .expertState(expertState)
                .sAddress(sAddress)
                .build();

    }
}


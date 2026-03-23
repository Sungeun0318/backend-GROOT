package com.green.backend.expert.entity;

import com.green.backend.BaseTime;
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
    private Integer expert_id; // 전문가번호 pk

    @Column( nullable = false, length = 30)
    private String expert_name; // 이름

    @Column( nullable = false, length = 30)
    private String company_number; // 연락처

    @Column( nullable = false, length = 30)
    private String expert_email; // 이메일

    private LocalDateTime expert_date; // 등록일

    @Column( nullable = false, length = 30)
    private String expert_state; // 상태



}

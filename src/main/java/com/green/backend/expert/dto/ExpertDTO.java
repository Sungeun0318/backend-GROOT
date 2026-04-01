package com.green.backend.expert.dto;

import com.green.backend.expert.entity.Expert;
import jakarta.persistence.Column;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpertDTO {
    private Long expertId; // 전문가번호 pk
    private String expertName; // 이름
    private String expertNumber; // 연락처
    private String expertEmail; // 이메일
    private String expertState; // 상태
    private String sAddress; // 주소

    private String createDate;
    private String updateDate;

    public Expert toEntity(){
        return Expert.builder()
                .expertId(expertId)
                .expertName(expertName)
                .expertNumber(expertNumber)
                .expertEmail(expertEmail)
                .expertState(expertState)
                .sAddress(sAddress)
                .build();
    }
}

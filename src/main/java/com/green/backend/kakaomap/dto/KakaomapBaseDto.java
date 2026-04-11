
package com.green.backend.kakaomap.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class KakaomapBaseDto {
    private Long memberId;
    private String companyName;
    private String partyName;
    private String address;
}
package com.green.backend.carbon.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpcomingScheduleDTO {
    private Long id;
    private String title;
    private String date;
    private String type;
}

package com.green.backend.carbon.dto;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class WeatherDTO {

    private String regionName;
    private String baseDate;
    private String baseTime;
    private double temperature;      // 기온 (℃)
    private double rainfall;         // 강수량 (mm)
    private int humidity;            // 습도 (%)
    private double windSpeed;        // 풍속 (m/s)
    private int windDirection;       // 풍향 (deg)
    private int precipitationType;   // 강수형태 (0:없음, 1:비, 2:비/눈, 3:눈)
}

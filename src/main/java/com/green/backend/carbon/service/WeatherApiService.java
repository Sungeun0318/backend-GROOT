package com.green.backend.carbon.service;

import com.green.backend.carbon.dto.WeatherDTO;
import com.green.backend.carbon.entity.RegionCode;
import com.green.backend.carbon.repository.RegionCodeRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
@RequiredArgsConstructor
public class WeatherApiService {

    private final RestTemplate restTemplate;
    private final RegionCodeRepository regionCodeRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${api.weather.key}")
    private String apiKey;

    @Value("${api.weather.base-url}")
    private String baseUrl;

    /**
     * 지역명으로 현재 날씨 조회 (DB 저장 X, 실시간 반환)
     */
    public WeatherDTO getCurrentWeather(String regionName) {
        RegionCode region = regionCodeRepository.findByRegionName(regionName)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 지역: " + regionName));

        return getCurrentWeatherByGrid(region.getNx(), region.getNy(), regionName);
    }

    /**
     * 격자 좌표로 현재 날씨 조회
     */
    public WeatherDTO getCurrentWeatherByGrid(int nx, int ny, String regionName) {
        LocalDateTime now = LocalDateTime.now();
        String baseDate = now.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String baseTime = now.format(DateTimeFormatter.ofPattern("HH")) + "00";

        String url = baseUrl + "/getUltraSrtNcst"
                + "?serviceKey=" + apiKey
                + "&numOfRows=10&pageNo=1"
                + "&dataType=JSON"
                + "&base_date=" + baseDate
                + "&base_time=" + baseTime
                + "&nx=" + nx
                + "&ny=" + ny;

        try {
            String response = restTemplate.getForObject(url, String.class);
            JsonNode root = objectMapper.readTree(response);
            JsonNode items = root.path("response").path("body").path("items").path("item");

            WeatherDTO weather = new WeatherDTO();
            weather.setRegionName(regionName);
            weather.setBaseDate(baseDate);
            weather.setBaseTime(baseTime);

            for (JsonNode item : items) {
                String category = item.get("category").asText();
                String value = item.get("obsrValue").asText();

                switch (category) {
                    case "T1H" -> weather.setTemperature(Double.parseDouble(value));
                    case "RN1" -> weather.setRainfall(Double.parseDouble(value));
                    case "REH" -> weather.setHumidity(Integer.parseInt(value));
                    case "WSD" -> weather.setWindSpeed(Double.parseDouble(value));
                    case "VEC" -> weather.setWindDirection(Integer.parseInt(value));
                    case "PTY" -> weather.setPrecipitationType(Integer.parseInt(value));
                }
            }

            return weather;

        } catch (Exception e) {
            log.error("기상청 API 호출 실패 ({}): {}", regionName, e.getMessage());
            return null;
        }
    }
}

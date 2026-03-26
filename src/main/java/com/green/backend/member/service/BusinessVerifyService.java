package com.green.backend.member.service;

import com.green.backend.member.dto.BusinessDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor

public class BusinessVerifyService {

    // 키
    @Value("${nts.api.key}")
    private String apiKey;

    // web 요청 객체
    private final WebClient webClient = WebClient.builder().build();


    public boolean verifyBusiness(BusinessDto dto) {
        Map<String, Object> requestBody = Map.of("b_no", List.of(dto.getBusiness_number()));

        Map response = webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .host("api.odcloud.kr")
                        .path("/api/nts-businessman/v1/status")
                        .queryParam("serviceKey", apiKey)
                        .build(true))
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        List<Map> data = (List<Map>) response.get("data");
        String status = (String) data.get(0).get("b_stt_cd");

        return status.equals("01");
    }

}

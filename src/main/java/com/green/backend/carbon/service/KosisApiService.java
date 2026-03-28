package com.green.backend.carbon.service;

import com.green.backend.carbon.entity.RegionCode;
import com.green.backend.carbon.entity.RegionalEmission;
import com.green.backend.carbon.repository.RegionCodeRepository;
import com.green.backend.carbon.repository.RegionalEmissionRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class KosisApiService {

    private final RestTemplate restTemplate;
    private final RegionCodeRepository regionCodeRepository;
    private final RegionalEmissionRepository regionalEmissionRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${api.kosis.key}")
    private String apiKey;

    @Value("${api.kosis.base-url}")
    private String baseUrl;

    @Value("${api.kosis.org-id}")
    private String orgId;

    @Value("${api.kosis.tbl-id}")
    private String tblId;

    // 17개 시도 순서 (KOSIS 블록 순서)
    private static final String[] REGION_ORDER = {
            "서울", "부산", "대구", "인천", "광주", "대전", "울산", "세종",
            "경기", "강원", "충북", "충남", "전북", "전남", "경북", "경남", "제주"
    };

    /**
     * KOSIS API에서 지역별 온실가스 배출량 조회 후 DB 저장
     */
    public void fetchAndSave(int startYear, int endYear) {
        String url = baseUrl
                + "?method=getList"
                + "&apiKey=" + apiKey
                + "&itmId=ALL&objL1=ALL&objL2="
                + "&format=json&jsonVD=Y"
                + "&prdSe=Y"
                + "&startPrdDe=" + startYear
                + "&endPrdDe=" + endYear
                + "&orgId=" + orgId
                + "&tblId=" + tblId;

        try {
            String response = restTemplate.getForObject(url, String.class);
            JsonNode dataArray = objectMapper.readTree(response);

            if (!dataArray.isArray()) {
                log.error("KOSIS API 응답 오류: {}", response);
                return;
            }

            // 연도별로 처리
            for (int year = startYear; year <= endYear; year++) {
                List<JsonNode> yearData = filterByYear(dataArray, year);
                saveYearData(yearData, year);
            }

            log.info("KOSIS 데이터 저장 완료: {}~{}", startYear, endYear);

        } catch (Exception e) {
            log.error("KOSIS API 호출 실패: {}", e.getMessage());
        }
    }

    private List<JsonNode> filterByYear(JsonNode dataArray, int year) {
        List<JsonNode> result = new ArrayList<>();
        for (JsonNode node : dataArray) {
            if (node.get("PRD_DE").asText().equals(String.valueOf(year))) {
                result.add(node);
            }
        }
        return result;
    }

    private void saveYearData(List<JsonNode> yearData, int year) {
        // C1 코드 기준 정렬
        yearData.sort(Comparator.comparing(n -> n.get("C1").asText()));

        // "합계" 행만 추출
        List<JsonNode> totals = new ArrayList<>();
        for (JsonNode node : yearData) {
            if ("합계".equals(node.get("C1_NM").asText())) {
                totals.add(node);
            }
        }

        // 짝수 인덱스 = LULUCF 포함 (블록0~16 = 17개 시도)
        for (int i = 0; i < Math.min(REGION_ORDER.length, totals.size() / 2); i++) {
            JsonNode regionTotal = totals.get(i * 2);
            double emissionValue = regionTotal.get("DT").asDouble();
            String regionName = REGION_ORDER[i];

            RegionCode regionCode = regionCodeRepository.findByRegionName(regionName)
                    .orElse(null);

            if (regionCode == null) {
                log.warn("지역코드 없음: {}", regionName);
                continue;
            }

            // 이미 있으면 업데이트, 없으면 생성
            RegionalEmission emission = regionalEmissionRepository
                    .findByRegionCodeAndYear(regionCode, year)
                    .orElse(RegionalEmission.builder()
                            .regionCode(regionCode)
                            .year(year)
                            .build());

            emission.setTotalEmission(emissionValue);
            regionalEmissionRepository.save(emission);
        }
    }
}

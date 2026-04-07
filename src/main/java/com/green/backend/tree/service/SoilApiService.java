package com.green.backend.tree.service;

import com.green.backend.tree.dto.SoilDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
@Slf4j
public class SoilApiService {

    private final RestTemplate restTemplate;

    @Value("${soil.api.key}")
    private String apiKey;

    private static final String SOIL_API_URL =
            "https://apis.data.go.kr/1390802/SoilEnviron/SoilCharac/V3/getSoilCharacter";

    /*
      지번코드(PNU)로 토양 정보 조회
     */
    public SoilDTO getSoilData(String pnuCode) {
        String url = SOIL_API_URL + "?serviceKey=" + apiKey + "&PNU_CD=" + pnuCode;

        try {
            String xml = restTemplate.getForObject(url, String.class);
            return parseXmlResponse(xml, pnuCode);
        } catch (Exception e) {
            log.error("토양 API 호출 실패: pnuCode={}, error={}", pnuCode, e.getMessage());
            return getDefaultSoilData(pnuCode);
        }
    }

    private SoilDTO parseXmlResponse(String xml, String pnuCode) {
        try {
            Document doc = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder()
                    .parse(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));

            NodeList items = doc.getElementsByTagName("item");
            if (items.getLength() == 0) {
                log.warn("토양 데이터 없음: pnuCode={}", pnuCode);
                return getDefaultSoilData(pnuCode);
            }

            Element item = (Element) items.item(0);

            return SoilDTO.builder()
                    .pnuCode(pnuCode)
                    .drainageGrade(getIntValue(item, "Soildra_Cd"))
                    .effectiveDepth(getIntValue(item, "Vldsoildep_Cd"))
                    .surfaceTexture(getIntValue(item, "Surtture_Cd"))
                    .gravelContent(getIntValue(item, "Sur_Ston_Cd"))
                    .erosionGrade(getIntValue(item, "Erosion_Cd"))
                    .forestSuitability(getIntValue(item, "Frst_Grd_Cd"))
                    .forestFactor(getIntValue(item, "Forest_Factor_Cd"))
                    .soilTypeCd(getIntValue(item, "Soil_Type_Cd"))
                    .slopeGrade(getIntValue(item, "Soil_Type_Geo_Cd"))
                    .build();
        } catch (Exception e) {
            log.error("토양 XML 파싱 실패: {}", e.getMessage());
            return getDefaultSoilData(pnuCode);
        }
    }

    private Integer getIntValue(Element item, String tagName) {
        NodeList nodes = item.getElementsByTagName(tagName);
        if (nodes.getLength() > 0) {
            String text = nodes.item(0).getTextContent().trim();
            if (!text.isEmpty()) {
                try {
                    return Integer.parseInt(text);
                } catch (NumberFormatException e) {
                    return null;
                }
            }
        }
        return null;
    }

    /*
      API 실패 시 기본값 (보통 토양 조건)
     */
    private SoilDTO getDefaultSoilData(String pnuCode) {
        return SoilDTO.builder()
                .pnuCode(pnuCode)
                .drainageGrade(2)     // 양호
                .effectiveDepth(2)    // 보통
                .surfaceTexture(3)    // 양토
                .gravelContent(1)     // 없음
                .erosionGrade(1)      // 없음
                .forestSuitability(2) // 2급지
                .forestFactor(0)
                .soilTypeCd(0)
                .slopeGrade(0)
                .build();
    }
}

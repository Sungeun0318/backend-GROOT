package com.green.backend.util;

/**
 * 한국 주소에서 시/구 단위 지역명을 추출하는 유틸리티
 */
public class AddressParser {

    /**
     * 주소에서 "시" 단위 이름 추출
     * 예: "서울특별시 강남구 테헤란로 10" → "서울"
     *     "경기도 수원시 영통구 삼성로 129" → "수원"
     *     "부산광역시 해운대구 우동 20" → "부산"
     *     "세종특별자치시 도움8로 80" → "세종"
     *     "충청북도 음성군 맹동면 두성리 1500" → "음성"
     */
    public static String extractCity(String address) {
        if (address == null || address.isBlank()) return null;

        // 괄호로 감싼 지번코드 제거: "(41173010200117460002) 경기도 ..." → "경기도 ..."
        address = address.replaceAll("\\(.*?\\)", "").trim();
        // 앞에 붙은 우편번호/숫자 제거: "30259 경기도 ..." → "경기도 ..."
        address = address.replaceAll("^[\\d-]+\\s+", "").trim();

        if (address.isBlank()) return null;

        String[] parts = address.trim().split("\\s+");
        String first = parts[0];

        // 특별시/광역시/특별자치시 → 첫 단어에서 추출
        if (first.contains("특별시") || first.contains("광역시") || first.contains("특별자치시")) {
            return first.replace("특별시", "").replace("광역시", "").replace("특별자치시", "");
        }

        // 특별자치도 (제주, 강원) → 첫 단어에서 추출
        if (first.contains("특별자치도")) {
            return first.replace("특별자치도", "");
        }

        // 도(경기도, 충청북도 등) → 두 번째 단어에서 "시/군" 추출
        if (first.endsWith("도") && parts.length >= 2) {
            String second = parts[1];
            if (second.contains("시")) {
                // "수원시" → "수원", "성남시" → "성남", "천안시" → "천안"
                return second.substring(0, second.indexOf("시"));
            }
            if (second.contains("군")) {
                // "음성군" → "음성"
                return second.substring(0, second.indexOf("군"));
            }
        }

        // fallback: 첫 단어 그대로
        return first;
    }

    /**
     * 주소에서 "구/군" 단위 이름 추출
     * 예: "서울특별시 강남구 테헤란로 10" → "강남구"
     *     "경기도 수원시 영통구 삼성로 129" → "영통구"
     *     "부산광역시 해운대구 우동 20" → "해운대구"
     */
    public static String extractDistrict(String address) {
        if (address == null || address.isBlank()) return null;

        String[] parts = address.trim().split("\\s+");

        for (String part : parts) {
            // "구"로 끝나는 단어 찾기 (강남구, 해운대구, 영통구 등)
            if (part.endsWith("구") && !part.endsWith("대구")) {
                return part;
            }
        }

        // 구가 없으면 군 찾기 (음성군, 이천시 등 군 단위 지역)
        for (String part : parts) {
            if (part.endsWith("군")) {
                return part;
            }
        }

        return null;
    }
}

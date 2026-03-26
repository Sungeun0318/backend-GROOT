package com.green.backend.carbon.controller;

import com.green.backend.carbon.dto.CarbonPredictionDTO;
import com.green.backend.carbon.dto.WeatherDTO;
import com.green.backend.carbon.service.CarbonService;
import com.green.backend.carbon.service.KosisApiService;
import com.green.backend.carbon.service.GirDataService;
import com.green.backend.carbon.service.WeatherApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carbon")
@RequiredArgsConstructor
public class CarbonController {

    private final CarbonService carbonService;
    private final KosisApiService kosisApiService;
    private final GirDataService girDataService;
    private final WeatherApiService weatherApiService;

    /**
     * 탄소 예측 대시보드 (월별 + 10년)
     * GET /api/carbon/predict/{memberId}?region=서울
     */
    @GetMapping("/predict/{memberId}")
    public ResponseEntity<CarbonPredictionDTO> getPrediction(
            @PathVariable Long memberId,
            @RequestParam(defaultValue = "서울") String region) {

        CarbonPredictionDTO prediction = carbonService.getPrediction(memberId, region);
        return ResponseEntity.ok(prediction);
    }

    /**
     * 실시간 날씨 조회
     * GET /api/carbon/weather?region=서울
     */
    @GetMapping("/weather")
    public ResponseEntity<WeatherDTO> getWeather(
            @RequestParam(defaultValue = "서울") String region) {

        WeatherDTO weather = weatherApiService.getCurrentWeather(region);
        return ResponseEntity.ok(weather);
    }

    /**
     * KOSIS 지역별 배출량 데이터 수동 적재
     * POST /api/carbon/load/kosis
     */
    @PostMapping("/load/kosis")
    public ResponseEntity<String> loadKosisData() {
        kosisApiService.fetchAndSave(2019, 2023);
        return ResponseEntity.ok("KOSIS 데이터 적재 완료");
    }

    /**
     * GIR 엑셀 데이터 수동 적재
     * POST /api/carbon/load/gir
     */
    @PostMapping("/load/gir")
    public ResponseEntity<String> loadGirData() {
        girDataService.loadExcelData();
        return ResponseEntity.ok("GIR 데이터 적재 완료");
    }
}

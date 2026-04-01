package com.green.backend.carbon.controller;

import com.green.backend.carbon.dto.*;
import com.green.backend.carbon.entity.RegionalEmission;
import com.green.backend.carbon.entity.CompanyEmission;
import com.green.backend.carbon.repository.RegionalEmissionRepository;
import com.green.backend.carbon.repository.CompanyEmissionRepository;
import com.green.backend.carbon.service.CarbonService;
import com.green.backend.carbon.service.DashboardService;
import com.green.backend.carbon.service.KosisApiService;
import com.green.backend.carbon.service.GirDataService;
import com.green.backend.carbon.service.WeatherApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carbon")
@RequiredArgsConstructor
public class CarbonController {

    private final CarbonService carbonService;
    private final DashboardService dashboardService;
    private final KosisApiService kosisApiService;
    private final GirDataService girDataService;
    private final WeatherApiService weatherApiService;
    private final RegionalEmissionRepository regionalEmissionRepository;
    private final CompanyEmissionRepository companyEmissionRepository;

    // ==================== 탄소 예측 ====================

    //  http://localhost:8080/api/carbon/predict/1?region=서울
    @GetMapping("/predict/{memberId}")
    public ResponseEntity<CarbonPredictionDTO> getPrediction(
            @PathVariable Long memberId,
            @RequestParam(defaultValue = "서울") String region) {

        CarbonPredictionDTO prediction = carbonService.getPrediction(memberId, region);
        return ResponseEntity.ok(prediction);
    }

    // ==================== 실시간 날씨 ====================

    // http://localhost:8080/api/carbon/weather?region=서울
    @GetMapping("/weather")
    public ResponseEntity<WeatherDTO> getWeather(
            @RequestParam(defaultValue = "서울") String region) {

        WeatherDTO weather = weatherApiService.getCurrentWeather(region);
        return ResponseEntity.ok(weather);
    }

    // ==================== 데이터 적재 ====================

    // http://localhost:8080/api/carbon/load/kosis (Body 없음)
    @PostMapping("/load/kosis")
    public ResponseEntity<String> loadKosisData() {
        kosisApiService.fetchAndSave(2019, 2023);
        return ResponseEntity.ok("KOSIS 데이터 적재 완료 (2019~2023, 17개 시도)");
    }

    // http://localhost:8080/api/carbon/load/gir (Body 없음)
    @PostMapping("/load/gir")
    public ResponseEntity<String> loadGirData() {
        girDataService.loadExcelData();
        return ResponseEntity.ok("GIR 데이터 적재 완료");
    }

    // ==================== 데이터 조회 ====================

    // http://localhost:8080/api/carbon/emissions/region?year=2023
    @GetMapping("/emissions/region")
    public ResponseEntity<List<RegionalEmission>> getRegionalEmissions(
            @RequestParam(defaultValue = "2023") int year) {

        List<RegionalEmission> emissions = regionalEmissionRepository.findByYear(year);
        return ResponseEntity.ok(emissions);
    }

    // http://localhost:8080/api/carbon/emissions/company?name=삼성
    @GetMapping("/emissions/company")
    public ResponseEntity<List<CompanyEmission>> getCompanyEmissions(
            @RequestParam String name) {

        List<CompanyEmission> emissions = companyEmissionRepository.findByCompanyNameContaining(name);
        return ResponseEntity.ok(emissions);
    }

    // ==================== 대시보드 ====================

    // http://localhost:8080/api/carbon/dashboard/summary/1
    @GetMapping("/dashboard/summary/{memberId}")
    public ResponseEntity<DashboardSummaryDTO> getDashboardSummary(
            @PathVariable Long memberId) {
        return ResponseEntity.ok(dashboardService.getSummary(memberId));
    }

    // http://localhost:8080/api/carbon/dashboard/monthly/1
    @GetMapping("/dashboard/monthly/{memberId}")
    public ResponseEntity<List<MonthlyAbsorptionDTO>> getMonthlyAbsorption(
            @PathVariable Long memberId) {
        return ResponseEntity.ok(dashboardService.getMonthlyAbsorption(memberId));
    }

    // http://localhost:8080/api/carbon/dashboard/species/1
    @GetMapping("/dashboard/species/{memberId}")
    public ResponseEntity<List<SpeciesDistributionDTO>> getSpeciesDistribution(
            @PathVariable Long memberId) {
        return ResponseEntity.ok(dashboardService.getSpeciesDistribution(memberId));
    }

    // http://localhost:8080/api/carbon/dashboard/applications/1
    @GetMapping("/dashboard/applications/{memberId}")
    public ResponseEntity<List<RecentApplicationDTO>> getRecentApplications(
            @PathVariable Long memberId) {
        return ResponseEntity.ok(dashboardService.getRecentApplications(memberId));
    }

    // http://localhost:8080/api/carbon/dashboard/schedules/1
    @GetMapping("/dashboard/schedules/{memberId}")
    public ResponseEntity<List<UpcomingScheduleDTO>> getUpcomingSchedules(
            @PathVariable Long memberId) {
        return ResponseEntity.ok(dashboardService.getUpcomingSchedules(memberId));
    }
}

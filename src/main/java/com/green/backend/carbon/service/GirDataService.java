package com.green.backend.carbon.service;

import com.green.backend.carbon.entity.CompanyEmission;
import com.green.backend.carbon.repository.CompanyEmissionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Slf4j
@Service
@RequiredArgsConstructor
public class GirDataService {

    private final CompanyEmissionRepository companyEmissionRepository;

    /*
     * GIR 엑셀 파일을 읽어서 DB에 저장
     * 필요한 컬럼: 법인명(companyName), 총 온실가스 배출량(companyEmission)
     */
    public void loadExcelData() {
        try {
            ClassPathResource resource = new ClassPathResource("data/gir_emission.xls");
            InputStream is = resource.getInputStream();
            Workbook workbook = new HSSFWorkbook(is);
            Sheet sheet = workbook.getSheetAt(0);

            int savedCount = 0;

            // 행0 = 헤더, 행1부터 데이터
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                try {
                    String companyName = getCellString(row.getCell(2)).trim();
                    double emissionAmount = parseNumber(getCellString(row.getCell(6)));

                    CompanyEmission emission = CompanyEmission.builder()
                            .companyName(companyName)
                            .companyEmission(emissionAmount)
                            .build();

                    companyEmissionRepository.save(emission);
                    savedCount++;

                } catch (Exception e) {
                    log.warn("행 {} 처리 실패: {}", i, e.getMessage());
                }
            }

            workbook.close();
            is.close();
            log.info("GIR 데이터 적재 완료: {}건", savedCount);

        } catch (Exception e) {
            log.error("GIR 엑셀 파일 읽기 실패: {}", e.getMessage());
        }
    }

    private String getCellString(Cell cell) {
        if (cell == null) return "";
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> String.valueOf(cell.getNumericCellValue());
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            default -> "";
        };
    }

    private double parseNumber(String value) {
        if (value == null || value.isBlank()) return 0;
        return Double.parseDouble(value.replace(",", "").trim());
    }
}

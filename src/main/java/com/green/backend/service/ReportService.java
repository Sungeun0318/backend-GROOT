package com.green.backend.service;

import com.green.backend.dto.ReportDTO;
import com.green.backend.entity.QrShare;
import com.green.backend.entity.Report;
import com.green.backend.repository.QrShareRepository;
import com.green.backend.repository.ReportRepository;
import com.green.backend.util.QrCodeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;
    private final QrShareRepository qrShareRepository;

    public Report createReport(ReportDTO dto) {
        Report report = Report.builder()
                .companyName(dto.getCompanyName())
                .registeredTrees(dto.getRegisteredTrees())
                .totalCarbonAbsorption(dto.getTotalCarbonAbsorption())
                .certificationLevel(dto.getCertificationLevel())
                .monthlyCarbonData(dto.getMonthlyCarbonData())
                .build();
        return reportRepository.save(report);
    }

    public Report getReport(Long id) {
        return reportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("보고서를 찾을 수 없습니다."));
    }

    public Map<String, String> generateQrShare(Long reportId, String baseUrl) {
        Report report = getReport(reportId);

        String token = UUID.randomUUID().toString();
        QrShare qrShare = QrShare.builder()
                .shareToken(token)
                .report(report)
                .build();
        qrShareRepository.save(qrShare);

        String shareLink = baseUrl + "/shared/" + token;
        try {
            String qrImage = QrCodeUtil.generateBase64Png(shareLink, 300, 300);
            return Map.of("token", token, "shareLink", shareLink, "qrImage", qrImage);
        } catch (Exception e) {
            throw new RuntimeException("QR 코드 생성 실패", e);
        }
    }

    public Report getReportByToken(String token) {
        QrShare qrShare = qrShareRepository.findByShareToken(token)
                .orElseThrow(() -> new RuntimeException("공유 링크를 찾을 수 없습니다."));

        if (qrShare.isExpired()) {
            return null;
        }

        return qrShare.getReport();
    }

    public void markAsSent(String token) {
        QrShare qrShare = qrShareRepository.findByShareToken(token)
                .orElseThrow(() -> new RuntimeException("공유 링크를 찾을 수 없습니다."));
        qrShare.setSent(true);
        qrShareRepository.save(qrShare);
    }
}

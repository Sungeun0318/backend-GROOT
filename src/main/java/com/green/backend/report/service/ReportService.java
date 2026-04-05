package com.green.backend.report.service;

import com.green.backend.certification.repository.CertificationRepository;
import com.green.backend.report.dto.ReportPreviewDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportService {


    private final CertificationRepository certificationRepository;





    public ReportPreviewDTO preview(Long mid){



    }
}

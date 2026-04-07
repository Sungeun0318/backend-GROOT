package com.green.backend.report.service;

import com.green.backend.application.entity.Application;
import com.green.backend.application.repository.ApplicationRepository;
import com.green.backend.certification.entity.Certification;
import com.green.backend.certification.repository.CertificationRepository;
import com.green.backend.expertreport.entity.ExpertReport;
import com.green.backend.expertreport.repository.ExpertReportRepository;
import com.green.backend.report.dto.ReportPreviewDTO;
import com.green.backend.report.dto.SpeciesDetailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final CertificationRepository certificationRepository;

    public ReportPreviewDTO preview(Long mid) {




}
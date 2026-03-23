package com.green.backend.expertreport.controller;

import com.green.backend.expertreport.service.ExpertReportService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/expert-reports")
public class ExpertReportController {

    private ExpertReportService expertReportService;
}

package com.green.backend.expertreport.controller;


import com.green.backend.expertreport.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailScheduler {

    private final EmailService emailService;

    // 매일 오전 9시 실행
    @Scheduled(cron = "0 07 13 * * *")
    public void sendSurveyMail() {
        emailService.sendDaySurveyLinks();
    }
}

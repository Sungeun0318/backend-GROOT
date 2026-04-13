package com.green.backend.expertreport.controller;

import com.green.backend.application.repository.ApplicationRepository;
import com.green.backend.expertreport.dto.SendLinkDto;
import com.green.backend.expertreport.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;
    private final ApplicationRepository applicationRepository;

    // 이메일 전송
    @PostMapping("/send-link")
    public ResponseEntity<?> sendLinkEmail(@RequestBody SendLinkDto request) {

        emailService.sendExpertLinkEmail(request.getEmail(), request.getDetailId());

        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "전문가 링크 이메일이 전송되었습니다.");

        return ResponseEntity.ok(result);
    }

    // 테스트용 or 수동 메일전송
    @PostMapping("/send-tomorrow")
    public ResponseEntity<?> sendTomorrowMails() {

        int count = emailService.sendDaySurveyLinks();

        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "자동 이메일 전송 완료");
        result.put("count", count);

        return ResponseEntity.ok(result);
    }

}
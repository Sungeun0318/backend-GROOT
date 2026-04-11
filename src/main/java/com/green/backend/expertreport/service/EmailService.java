package com.green.backend.expertreport.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Value("${app.frontend-url}")
    private String frontendUrl;

    public void sendExpertLinkEmail(String toEmail, Long detailId) {
        String link = frontendUrl + "/expert-report/" + detailId;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("dlxogud555@gmail.com");
        message.setTo(toEmail);
        message.setSubject("답사 보고서 링크");
        message.setText(
                "안녕하세요.\n\n" +
                        "아래 링크를 클릭하여 답사 보고서를 작성해주세요.\n\n" +
                        link + "\n\n"
        );

        javaMailSender.send(message);
    }
}

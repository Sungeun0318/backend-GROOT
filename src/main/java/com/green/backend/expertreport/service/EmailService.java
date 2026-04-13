package com.green.backend.expertreport.service;

import com.green.backend.application.entity.Application;
import com.green.backend.application.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final ApplicationRepository applicationRepository;

    @Value("${app.frontend-url}")
    private String frontendUrl;

    public void sendExpertLinkEmail(String toEmail, Long detailId, String expertName) {
        String link = frontendUrl + "/expert-report/" + detailId;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("dlxogud555@gmail.com");
        message.setTo(toEmail);
        message.setSubject("답사 보고서 링크");
        message.setText(
                "안녕하세요 " + expertName + " 전문가님.\n\n" +
                        "아래 링크를 클릭하여 답사 보고서를 작성해주세요.\n\n" +
                        link + "\n\n"
        );

        javaMailSender.send(message);
    }


    // 전문가에게 발송
    public int sendDaySurveyLinks() {
        LocalDate day = LocalDate.now();

        List<Application> applications =
                applicationRepository.findAllBySurveyStatusAndDueStartDate("답사진행중", day);

        int count = 0;

        for (Application application : applications) {

            if (application.getExpertId() == null) continue;

            Long detailId = application.getDetailId();
            String expertEmail = application.getExpertId().getExpertEmail();
            String expertName = application.getExpertId().getExpertName();

            if (expertEmail == null || expertEmail.isBlank()) continue;

            sendExpertLinkEmail(expertEmail, detailId, expertName);
            count++;
        }

        return count;
    }
}

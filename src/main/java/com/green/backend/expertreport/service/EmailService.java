package com.green.backend.expertreport.service;

import com.green.backend.application.entity.Application;
import com.green.backend.application.repository.ApplicationRepository;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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

        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom("dlxogud555@gmail.com");
            helper.setTo(toEmail);
            helper.setSubject("답사 보고서 링크");

            String htmlContent =
                    "<p>안녕하세요 " + expertName + " 전문가님.</p>" +
                            "<p>아래 버튼을 클릭하여 답사 보고서를 작성해주세요.</p>" +
                            "<a href='" + link + "' style='color:blue;'>답사 보고서 작성하기</a>";

            helper.setText(htmlContent, true); // true → HTML

            javaMailSender.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
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

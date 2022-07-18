package com.example.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;


@Service
public class MailSendService {

    @Autowired
    private MailSender mailSender;

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMailMessage(final SimpleMailMessage simpleMailMessage) {
        System.out.println("Mail Sender: " + mailSender.getClass().getName());
        this.mailSender.send(simpleMailMessage);
    }

    public void sendMailMessageWithAttachments() {
        this.javaMailSender.send(new MimeMessagePreparator() {

            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper helper =
                        new MimeMessageHelper(mimeMessage, true, "UTF-8");
                helper.addTo("aa@aa.com");
                helper.setFrom("bb@bb.com");

                InputStreamSource data = new ByteArrayResource("".getBytes());
                helper.addAttachment("test.txt", data);
                helper.setSubject("test subject text");
                helper.setText("mime body", false);
            }
        });
    }
}

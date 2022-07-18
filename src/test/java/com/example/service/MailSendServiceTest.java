package com.example.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;


@SpringBootTest
class MailSendServiceTest {

    @Autowired
    private MailSendService notificationService;

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testSendMail() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("qq@gmail.com");
        simpleMailMessage.setTo("ww@gmail.com");
        simpleMailMessage.setSubject("test subject text");
        simpleMailMessage.setText("test text");

        notificationService.sendMailMessage(simpleMailMessage);
    }

    @Test
    void testSendMailWithAttachments() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("qq@gmail.com");
        simpleMailMessage.setTo("ww@gmail.com");
        simpleMailMessage.setSubject("test subject text");
        simpleMailMessage.setText("test text");

        notificationService.sendMailMessage(simpleMailMessage);
    }

}

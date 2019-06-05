package com.zanatciu.backend.config.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SimpMailService{

    private JavaMailSender mailSender;

    @Autowired
    public SimpMailService(
            JavaMailSender mailSender
    ){
        this.mailSender = mailSender;
    }

    public void sendSimpleMessage(
            String to, String subject, String text
    ){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);
    }


}

package com.zanatciu.backend.config.mail.service;

import com.zanatciu.backend.config.EnvironmentVariables;
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

    public void emailNotFoundMessage(String to){

        String subject = "Email-i nuk eshte i rregjistruar!";

        String text = "Nje kerkese per te rivendosur fjalekalimin me kete email eshte bere\n" +
                "\nJu lutem sigurohuni qe askush nuk po e perdor email-in tuaj pa leje!";

        sendSimpleMessage(to, subject, text);
    }

    public void passwordResetMessage(String to, String token){

        String subject = "RIVENDOSJE fjalekimi";

        String text = "Ju lutem klikoni linkun e meposhtem per te rivendosur fjalekalimin"
                + "\n\n\n"
                + EnvironmentVariables.APP_IP + ":8080/auth/reset/" + token;
        sendSimpleMessage(to, subject, text);

    }

    public void passwordResetFinishedMessage(
            String to, String password
    ){
        String subject = "Your new PASSWORD";

        String text = "Below is your new password, please change it for security reasons\n\n\n" +
                "PASSWORD: " + password;

        sendSimpleMessage(to, subject, text);
    }


}

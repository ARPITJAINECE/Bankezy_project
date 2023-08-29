package com.bankezy.mailMessenger;

import com.bankezy.config.MailConfig;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class MailMessenger {


    public static void htmlEmailMessenger(String from, String toMail, String subject, String body) throws MessagingException {
        // Get Mail Config:
        JavaMailSender sender = MailConfig.getMailConfig();
        // Set Mime Message:
        MimeMessage message = sender.createMimeMessage();//Multipurpose Internet Mail Extensions
        // Set Mime Message Helper:
        MimeMessageHelper htmlMessage = new MimeMessageHelper(message, true);

        // Set Mail Attributes / Properties:
        htmlMessage.setTo(toMail);
        htmlMessage.setFrom(from);
        htmlMessage.setSubject(subject);
        htmlMessage.setText(body, true);
        // Send Message:
        sender.send(message);
    }
    // End Of HTML EMAIL MESSAGE METHOD.
}







//
//
//package com.bankezy.mailMessenger;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Component;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//
//@Component
//public class MailMessenger {
//
//    private static final JavaMailSender mailSender;
//
//    @Autowired
//    public MailMessenger(JavaMailSender mailSender) {
//        this.mailSender = mailSender;
//    }
//
//    public static void htmlEmailMessenger(String from, String toMail, String subject, String body) throws MessagingException {
//        // Set Mime Message:
//        MimeMessage message = mailSender.createMimeMessage();
//        // Set Mime Message Helper:
//        MimeMessageHelper htmlMessage = new MimeMessageHelper(message, true);
//
//        // Set Mail Attributes / Properties:
//        htmlMessage.setTo(toMail);
//        htmlMessage.setFrom(from);
//        htmlMessage.setSubject(subject);
//        htmlMessage.setText(body, true);
//        // Send Message:
//        mailSender.send(message);
//    }
//    // End Of HTML EMAIL MESSAGE METHOD.
//}

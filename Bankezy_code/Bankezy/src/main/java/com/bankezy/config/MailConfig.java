//package com.bankezy.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//
//import java.util.Properties;
//
//public class MailConfig {
//
//    @Bean
//    public static JavaMailSenderImpl getMailConfig(){
//        JavaMailSenderImpl emailConfig = new JavaMailSenderImpl();
//
//        // Set Properties:
//        Properties props = emailConfig.getJavaMailProperties();
//        props.put("mail.transport.protocol", "smtp");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.debug", "true");
//
//        // Set Mail Credentials:
//        emailConfig.setHost("localhost");
//        emailConfig.setPort(25);
//        emailConfig.setUsername("no-reply@somecompany.com");
//        emailConfig.setPassword("password123");
//
//        return emailConfig;
//    }
//    // End Of Email Config Method.
//}




package com.bankezy.config;

        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.mail.javamail.JavaMailSenderImpl;

        import java.util.Properties;
//@Configuration
public class MailConfig {

    @Bean
    public static JavaMailSenderImpl getMailConfig(){
        JavaMailSenderImpl emailConfig = new JavaMailSenderImpl();

        // Set Properties:
        Properties props = emailConfig.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        //uncomment it to use through gmail verification
//        props.put("mail.smtp.ssl.enable","true");
        props.put("mail.debug", "true");

        // Set Mail Credentials:
        emailConfig.setHost("sandbox.smtp.mailtrap.io");
        emailConfig.setPort(2525);
        //uncomment it to use through gmail verification
//        emailConfig.setProtocol("smtps");
        emailConfig.setUsername("73fd2402474923");
        emailConfig.setPassword("c6356405cf723c");

        return emailConfig;
    }
    // End Of Email Config Method.
}


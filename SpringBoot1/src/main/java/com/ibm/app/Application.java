package com.ibm.app;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
 
import com.ibm.bean.Mail;
import com.ibm.services.MailService;
 
@SpringBootApplication
@ComponentScan(basePackages = {
    "com.ibm"
})
public class Application {
    public static void main(String[] args) {
 
        Mail mail = new Mail();
        mail.setMailFrom("satyasri052.com");
        mail.setMailTo("satyasri052.com");
        mail.setMailSubject("Spring Boot - Email Example");
        mail.setMailContent("Learn How to send Email using Spring Boot!!!\n\nThanks\nwww.technicalkeeda.com");
 
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        MailService mailService = (MailService) ctx.getBean("mailService");
        mailService.sendEmail(mail);
 
    }
}
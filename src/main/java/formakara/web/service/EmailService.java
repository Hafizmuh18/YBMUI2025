package formakara.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import org.springframework.scheduling.annotation.Async;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Async
    public void sendEmail(String to, String subject, String body) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);
            message.setFrom("hafizmuh18@gmail.com");
            System.out.println("Sending message...");
            mailSender.send(message);
            System.out.println("Message sent");
        } catch (Exception e) {
            System.err.println("Failed to send email: " + e.getMessage());
        }
    }
}



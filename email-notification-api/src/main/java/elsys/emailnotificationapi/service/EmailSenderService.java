package elsys.emailnotificationapi.service;

import org.springframework.scheduling.annotation.Async;


public interface EmailSenderService {
    @Async
    void sendEmail(String to, String subject, String text);
}

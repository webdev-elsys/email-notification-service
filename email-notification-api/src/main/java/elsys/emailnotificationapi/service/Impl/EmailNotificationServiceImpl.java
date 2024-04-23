package elsys.emailnotificationapi.service.Impl;

import elsys.emailnotificationapi.dto.NotificationData;
import elsys.emailnotificationapi.service.EmailNotificationService;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationServiceImpl implements EmailNotificationService {
    @Override
    public void sendReservationRequestedNotification(NotificationData notificationData) {
        // TODO: Send email
        System.out.println("Email sent: " + notificationData.toString());
    }

    @Override
    public void sendReservationProcessedNotification(NotificationData notificationData) {
        // TODO: Send email
        System.out.println("Email sent: " + notificationData.toString());
    }
}

package elsys.emailnotificationapi.service.Impl;

import elsys.emailnotificationapi.dto.NotificationData;
import elsys.emailnotificationapi.service.EmailNotificationService;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationServiceImpl implements EmailNotificationService {
    @Override
    public void sendReservationRequestNotification(NotificationData notificationData) {
        // TODO: Send email
    }
}

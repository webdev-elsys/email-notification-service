package elsys.emailnotificationapi.service;

import elsys.emailnotificationapi.dto.NotificationData;

public interface EmailNotificationService {
    public void sendReservationRequestNotification(NotificationData notificationData);
}

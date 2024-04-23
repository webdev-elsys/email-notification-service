package elsys.emailnotificationapi.service;

import elsys.emailnotificationapi.dto.NotificationData;

public interface EmailNotificationService {
    public void sendReservationRequestedNotification(NotificationData notificationData);
    public void sendReservationProcessedNotification(NotificationData notificationData);
}

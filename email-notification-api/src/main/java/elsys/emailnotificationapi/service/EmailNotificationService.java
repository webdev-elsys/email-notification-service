package elsys.emailnotificationapi.service;

import elsys.emailnotificationapi.dto.NotificationData;

public interface EmailNotificationService {
    public void sendReservationRequestedNotification(NotificationData notificationData);
    public void sendReservationConfirmedNotification(NotificationData notificationData);
    public void sendReservationRejectedNotification(NotificationData notificationData);
    public void sendReservationCancelledNotification(NotificationData notificationData);
    public void sendReservationCompletedNotification(NotificationData notificationData);
}

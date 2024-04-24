package elsys.emailnotificationapi.service.Impl;

import elsys.emailnotificationapi.dto.NotificationData;
import elsys.emailnotificationapi.service.EmailNotificationService;
import elsys.emailnotificationapi.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailNotificationServiceImpl implements EmailNotificationService {
    private final EmailSenderService emailService;

    String to = "simeon.g.angelov.2019@elsys-bg.org"; // TODO: Change this Chris

    @Override
    public void sendReservationRequestedNotification(NotificationData notificationData) {
        emailService.sendEmail(
                to,
                "Reservation requested",
                "Reservation requested for property: " + notificationData.propertyUuid() +
                        " room: " + notificationData.roomUuid() +
                        " by client: " + notificationData.clientUuid() +
                        " from " + notificationData.checkIn() +
                        " to " + notificationData.checkOut() +
                        " for " + notificationData.guests() + " guests. " +
                        "\nTotal price: " + notificationData.totalPrice() +
                        "\nComment: " + notificationData.comment()
        );
    }

    @Override
    public void sendReservationConfirmedNotification(NotificationData notificationData) {
        emailService.sendEmail(
                to,
                "Reservation confirmed",
                "Reservation confirmed for property: " + notificationData.propertyUuid() +
                        " room: " + notificationData.roomUuid() +
                        " by client: " + notificationData.clientUuid() +
                        " from " + notificationData.checkIn() +
                        " to " + notificationData.checkOut() +
                        " for " + notificationData.guests() + " guests. " +
                        "\nTotal price: " + notificationData.totalPrice() +
                        "\nComment: " + notificationData.comment()
        );
    }

    @Override
    public void sendReservationRejectedNotification(NotificationData notificationData) {
        emailService.sendEmail(
                to,
                "Reservation rejected",
                "Reservation rejected for property: " + notificationData.propertyUuid() +
                        " room: " + notificationData.roomUuid() +
                        " by client: " + notificationData.clientUuid() +
                        " from " + notificationData.checkIn() +
                        " to " + notificationData.checkOut() +
                        " for " + notificationData.guests() + " guests. " +
                        "\nTotal price: " + notificationData.totalPrice() +
                        "\nComment: " + notificationData.comment()
        );
    }

    @Override
    public void sendReservationCancelledNotification(NotificationData notificationData) {
        emailService.sendEmail(
                to,
                "Reservation cancelled",
                "Reservation" + notificationData.uuid() +
                        "cancelled for property: " + notificationData.propertyUuid() +
                        " room: " + notificationData.roomUuid() +
                        " by client: " + notificationData.clientUuid() +
                        " from " + notificationData.checkIn() +
                        " to " + notificationData.checkOut() +
                        " for " + notificationData.guests() + " guests. " +
                        "\nTotal price: " + notificationData.totalPrice() +
                        "\nComment: " + notificationData.comment()
        );
    }

    @Override
    public void sendReservationCompletedNotification(NotificationData notificationData) {
        emailService.sendEmail(
                to,
                "Reservation completed",
                "Reservation completed for property: " + notificationData.propertyUuid() +
                        " room: " + notificationData.roomUuid() +
                        " by client: " + notificationData.clientUuid() +
                        " from " + notificationData.checkIn() +
                        " to " + notificationData.checkOut() +
                        " for " + notificationData.guests() + " guests. " +
                        "\nTotal price: " + notificationData.totalPrice() +
                        "\nComment: " + notificationData.comment()
        );
    }
}

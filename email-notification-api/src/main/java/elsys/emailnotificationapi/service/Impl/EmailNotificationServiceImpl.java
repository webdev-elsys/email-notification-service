package elsys.emailnotificationapi.service.Impl;

import elsys.emailnotificationapi.dto.NotificationData;
import elsys.emailnotificationapi.service.EmailNotificationService;
import elsys.emailnotificationapi.service.EmailSenderService;
import elsys.emailnotificationapi.service.PropertyApiService;
import elsys.emailnotificationapi.service.UserApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailNotificationServiceImpl implements EmailNotificationService {
    private final EmailSenderService emailService;
    private final UserApiService userApiService;
    private final PropertyApiService propertyApiService;

    @Override
    public void sendReservationRequestedNotification(NotificationData notificationData) {
        emailService.sendEmail(
                userApiService.getUserEmail(propertyApiService.getOwnerUuidByPropertyUuid(notificationData.propertyUuid())),
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
                userApiService.getUserEmail(notificationData.clientUuid()),
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
                userApiService.getUserEmail(notificationData.clientUuid()),
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
                userApiService.getUserEmail(propertyApiService.getOwnerUuidByPropertyUuid(notificationData.propertyUuid())),
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
                userApiService.getUserEmail(notificationData.clientUuid()),
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

        emailService.sendEmail(
                userApiService.getUserEmail(propertyApiService.getOwnerUuidByPropertyUuid(notificationData.propertyUuid())),
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

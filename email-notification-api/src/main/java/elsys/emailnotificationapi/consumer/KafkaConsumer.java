package elsys.emailnotificationapi.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import elsys.emailnotificationapi.dto.NotificationData;
import elsys.emailnotificationapi.service.EmailNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {
    private final EmailNotificationService emailNotificationService;

    @KafkaListener(
        topics = "${kafka.reservation-pending-topic}",
        groupId = "${kafka.group-id}",
        containerFactory = "notificationDataKafkaListenerContainerFactory"
    )
    public void handleReservationRequest(String message) throws JsonProcessingException {
        emailNotificationService.sendReservationRequestedNotification(deserializeNotificationData(message));
    }

    @KafkaListener(
        topics = "${kafka.reservation-confirmed-topic}",
        groupId = "${kafka.group-id}",
        containerFactory = "notificationDataKafkaListenerContainerFactory"
    )
    public void handleReservationConfirmed(String message) throws JsonProcessingException {
        emailNotificationService.sendReservationConfirmedNotification(deserializeNotificationData(message));
    }

    @KafkaListener(
        topics = "${kafka.reservation-rejected-topic}",
        groupId = "${kafka.group-id}",
        containerFactory = "notificationDataKafkaListenerContainerFactory"
    )
    public void handleReservationRejected(String message) throws JsonProcessingException {
        emailNotificationService.sendReservationRejectedNotification(deserializeNotificationData(message));
    }

    @KafkaListener(
        topics = "${kafka.reservation-cancelled-topic}",
        groupId = "${kafka.group-id}",
        containerFactory = "notificationDataKafkaListenerContainerFactory"
    )
    public void handleReservationCancelled(String message) throws JsonProcessingException {
        emailNotificationService.sendReservationCancelledNotification(deserializeNotificationData(message));
    }

    @KafkaListener(
        topics = "${kafka.reservation-completed-topic}",
        groupId = "${kafka.group-id}",
        containerFactory = "notificationDataKafkaListenerContainerFactory"
    )
    public void handleReservationCompleted(String message) throws JsonProcessingException {
        emailNotificationService.sendReservationCompletedNotification(deserializeNotificationData(message));
    }

    private NotificationData deserializeNotificationData(String message) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper(); // I have tried to use JsonDeserializer, but it didn't work...
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.readValue(message, NotificationData.class);
    }
}

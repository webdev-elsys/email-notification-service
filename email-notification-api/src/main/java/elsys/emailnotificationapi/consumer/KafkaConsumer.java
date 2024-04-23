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
        topics = "${kafka.reservation-request-topic}",
        groupId = "${kafka.group-id}",
        containerFactory = "notificationDataKafkaListenerContainerFactory"
    )
    public void handleReservationRequest(String message) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper(); // I have tried to use JsonDeserializer, but it didn't work...
        objectMapper.registerModule(new JavaTimeModule());
        NotificationData notificationData = objectMapper.readValue(message, NotificationData.class);
        emailNotificationService.sendReservationRequestNotification(notificationData);
    }
}

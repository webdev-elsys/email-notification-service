package elsys.emailnotificationapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public record NotificationData(
    @JsonProperty String uuid,
    @JsonProperty String propertyUuid,
    @JsonProperty String roomUuid,
    @JsonProperty String clientUuid,
    @JsonProperty LocalDate checkIn,
    @JsonProperty LocalDate checkOut,
    @JsonProperty int guests,
    @JsonProperty Float totalPrice,
    @JsonProperty String comment
) { }
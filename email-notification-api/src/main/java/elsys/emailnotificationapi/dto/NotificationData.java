package elsys.emailnotificationapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record NotificationData(
    @JsonProperty String uuid,
    @JsonProperty String propertyUuid,
    @JsonProperty String roomUuid,
    @JsonProperty String clientUuid,
    @JsonProperty LocalDate checkIn,
    @JsonProperty LocalDate checkOut,
    @JsonProperty int guests,
    @JsonProperty Float totalPrice,
    @JsonProperty String status,
    @JsonProperty String comment
) { }
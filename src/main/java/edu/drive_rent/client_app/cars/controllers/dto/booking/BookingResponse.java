package edu.drive_rent.client_app.cars.controllers.dto.booking;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class BookingResponse {

    @JsonProperty("is_booked")
    private Boolean isBooked;

    @JsonProperty("order_id")
    private String orderId;

    @JsonProperty("error")
    private String error;
}

package edu.drive_rent.client_app.cars.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class RateInfo {

    @JsonProperty("car_id")
    private String carId;

    @JsonProperty("min_days")
    private int minDays;

    @JsonProperty("max_days")
    private int maxDays;

    @JsonProperty("price_per_day")
    private double pricePerDay;
}

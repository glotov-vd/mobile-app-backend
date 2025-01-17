package edu.drive_rent.client_app.cars.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CarDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("model")
    private String model;

    @JsonProperty("class")
    private String carClazz;

    @JsonProperty("engine")
    private EngineDTO engine;

    @JsonProperty("transmission_type")
    private String transmissionType;

    @JsonProperty("release_year")
    private int releaseYear;

    @JsonProperty("number_of_seats")
    private int numberOfSeats;
}

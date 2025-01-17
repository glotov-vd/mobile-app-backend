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
public class EngineDTO {

    @JsonProperty("type")
    private String type;

    @JsonProperty("power")
    private int power;

    @JsonProperty("volume")
    private double volume;
}

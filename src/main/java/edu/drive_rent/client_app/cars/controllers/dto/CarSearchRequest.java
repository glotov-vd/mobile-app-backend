package edu.drive_rent.client_app.cars.controllers.dto;

import edu.drive_rent.client_app.cars.models.CarClazz;
import edu.drive_rent.client_app.cars.models.EngineType;
import edu.drive_rent.client_app.cars.models.TransmissionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CarSearchRequest {

    private String brand;
    private String model;
    private CarClazz carClass;
    private EngineType engineType;
    private Integer enginePower;
    private Float engineVolume;
    private TransmissionType transmissionType;
    private Integer releaseYear;
    private Integer numberOfSeats;
}

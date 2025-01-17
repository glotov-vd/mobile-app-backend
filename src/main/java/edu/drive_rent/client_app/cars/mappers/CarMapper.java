package edu.drive_rent.client_app.cars.mappers;

import edu.drive_rent.client_app.cars.controllers.dto.CarDTO;
import edu.drive_rent.client_app.cars.controllers.dto.EngineDTO;
import edu.drive_rent.client_app.cars.models.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public static CarDTO toCarDTO(Car car) {
        if (car == null) return null;

        var engineDTO = EngineDTO.builder()
                .type(car.getEngineType().toString())
                .power(car.getEnginePower())
                .volume(car.getEngineVolume())
                .build();

        return CarDTO.builder()
                .id(car.getId())
                .brand(car.getBrand().getName())
                .model(car.getModel().getName())
                .carClazz(car.getCarClazz().toString())
                .engine(engineDTO)
                .transmissionType(car.getTransmissionType().toString())
                .releaseYear(car.getReleaseYear())
                .numberOfSeats(car.getNumberOfSeats())
                .build();
    }
}

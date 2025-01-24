package edu.drive_rent.client_app.cars.services;

import edu.drive_rent.client_app.cars.controllers.dto.CarDTO;
import edu.drive_rent.client_app.cars.controllers.dto.CarSearchRequest;
import edu.drive_rent.client_app.cars.models.Car;
import edu.drive_rent.client_app.cars.models.CarBrand;
import edu.drive_rent.client_app.cars.repositories.CarBrandRepository;
import edu.drive_rent.client_app.cars.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final CarBrandRepository carBrandRepository;

    public List<Car> getAllCars() {

        return carRepository.findAll();
    }

    public Car getCarById(String id) {

        return carRepository.findCarById(id)
                .orElseThrow(() -> new RuntimeException("Car not found"));
    }

    public List<Car> searchCars(CarSearchRequest searchRequest) {
        return carRepository.searchCars(
                searchRequest.getBrand(),
                searchRequest.getModel(),
                searchRequest.getCarClass(),
                searchRequest.getEngineType(),
                searchRequest.getEnginePower(),
                searchRequest.getEngineVolume(),
                searchRequest.getTransmissionType(),
                searchRequest.getReleaseYear(),
                searchRequest.getNumberOfSeats()
        );
    }

    public List<CarBrand> getAllBrands() {
        return carBrandRepository.findAll();
    }
}

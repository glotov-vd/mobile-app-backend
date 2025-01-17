package edu.drive_rent.client_app.cars.services;

import edu.drive_rent.client_app.cars.models.Car;
import edu.drive_rent.client_app.cars.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public List<Car> getAllCarsByBrand(String brand) {
        return carRepository.findAllByBrand(brand);
    }

    public List<Car> getAllCarsByBrandAndModel(String brand, String model) {
        return carRepository.findAllByBrandAndModel(brand, model);
    }
}

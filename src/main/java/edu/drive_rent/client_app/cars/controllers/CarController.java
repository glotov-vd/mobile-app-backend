package edu.drive_rent.client_app.cars.controllers;

import edu.drive_rent.client_app.cars.controllers.dto.CarDTO;
import edu.drive_rent.client_app.cars.mappers.CarMapper;
import edu.drive_rent.client_app.cars.services.CarService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/cars", produces = "application/json;charset=UTF-8")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public List<CarDTO> getAllCars() {

        return carService.getAllCars().stream()
                .map(CarMapper::toCarDTO)
                .toList();
    }

    @GetMapping("/{brand}")
    public List<CarDTO> getCarsByBrand(@PathVariable String brand) {

        return carService.getAllCarsByBrand(brand).stream()
                .map(CarMapper::toCarDTO)
                .toList();
    }

    @GetMapping("/{brand}/{model}")
    public List<CarDTO> getCarsByModel(@PathVariable String brand,
                                       @PathVariable String model
    ) {

        return carService.getAllCarsByBrandAndModel(brand, model).stream()
                .map(CarMapper::toCarDTO)
                .toList();
    }
}

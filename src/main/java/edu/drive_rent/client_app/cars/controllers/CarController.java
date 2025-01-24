package edu.drive_rent.client_app.cars.controllers;

import edu.drive_rent.client_app.cars.controllers.dto.CarDTO;
import edu.drive_rent.client_app.cars.controllers.dto.CarSearchRequest;
import edu.drive_rent.client_app.cars.mappers.CarMapper;
import edu.drive_rent.client_app.cars.models.CarBrand;
import edu.drive_rent.client_app.cars.models.CarClazz;
import edu.drive_rent.client_app.cars.models.EngineType;
import edu.drive_rent.client_app.cars.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/{id}")
    public CarDTO getCarById(@PathVariable("id") String id) {

        return CarMapper.toCarDTO(carService.getCarById(id));
    }

    @GetMapping("/brands")
    public List<CarBrand> getAllCarBrands() {

        return carService.getAllBrands();
    }

    @GetMapping("/search")
    public List<CarDTO> searchCars(@RequestParam(required = false) String brand,
                                   @RequestParam(required = false) String model,
                                   @RequestParam(required = false) CarClazz carClass,
                                   @RequestParam(required = false) EngineType engineType,
                                   @RequestParam(required = false) Integer enginePower,
                                   @RequestParam(required = false) Float engineVolume

    ) {
        var searchRequest = CarSearchRequest.builder()
                .brand(brand)
                .model(model)
                .carClass(carClass)
                .engineType(engineType)
                .enginePower(enginePower)
                .engineVolume(engineVolume)
                .build();

        return carService.searchCars(searchRequest).stream()
                .map(CarMapper::toCarDTO)
                .toList();
    }
}

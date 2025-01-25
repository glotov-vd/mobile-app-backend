package edu.drive_rent.client_app.cars.controllers;

import edu.drive_rent.client_app.cars.controllers.dto.RateInfo;
import edu.drive_rent.client_app.cars.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cars")
@RequiredArgsConstructor
public class RentalRateController {

    private final CarService carService;


    @GetMapping("/{id}/rate")
    public RateInfo getRentalRate(@PathVariable("id") String carId) {

        var carRate = carService.getCarRental(carId);

        return RateInfo.builder()
                .carId(carId)
                .minDays(carRate.getMinDays())
                .maxDays(carRate.getMaxDays())
                .pricePerDay(carRate.getPricePerDay())
                .build();
    }
}

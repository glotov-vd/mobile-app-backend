package edu.drive_rent.client_app.cars.controllers;

import edu.drive_rent.client_app.cars.models.CarBrand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/brands")
public class CarBrandController {

    @GetMapping
    public List<CarBrand> getAllCarBrands() {

        return null;
    }
}

package edu.drive_rent.client_app.cars.controllers;

import edu.drive_rent.client_app.auth.models.User;
import edu.drive_rent.client_app.booking.services.BookingService;
import edu.drive_rent.client_app.cars.controllers.dto.CarDTO;
import edu.drive_rent.client_app.cars.controllers.dto.CarSearchRequest;
import edu.drive_rent.client_app.cars.controllers.dto.booking.BookingRequest;
import edu.drive_rent.client_app.cars.controllers.dto.booking.BookingResponse;
import edu.drive_rent.client_app.cars.mappers.CarMapper;
import edu.drive_rent.client_app.cars.models.CarBrand;
import edu.drive_rent.client_app.cars.models.CarClazz;
import edu.drive_rent.client_app.cars.models.EngineType;
import edu.drive_rent.client_app.cars.models.TransmissionType;
import edu.drive_rent.client_app.cars.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/cars", produces = "application/json;charset=UTF-8")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;
    private final BookingService bookingService;

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

    @GetMapping("/{id}/availability")
    public Boolean checkAvailability(@PathVariable String id,
                                     @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                     @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate
    ) {

        return bookingService.isCarAvailable(id, startDate, endDate);
    }

    @PostMapping("/{id}/book")
    public BookingResponse bookCar(@PathVariable("id") String id,
                                   @RequestBody BookingRequest bookingRequest,
                                   @AuthenticationPrincipal UserDetails userDetails

    ) {
        String userId = ((User) userDetails).getId();

        String orderId = bookingService.bookCar(id, bookingRequest, userId);

        return BookingResponse.builder()
                .orderId(orderId)
                .isBooked(!orderId.isBlank())
                .build();
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
                                   @RequestParam(required = false) Float engineVolume,
                                   @RequestParam(required = false) TransmissionType transmissionType,
                                   @RequestParam(required = false) Integer releaseYear,
                                   @RequestParam(required = false) Integer numberOfSeats

    ) {
        var searchRequest = CarSearchRequest.builder()
                .brand(brand)
                .model(model)
                .carClass(carClass)
                .engineType(engineType)
                .enginePower(enginePower)
                .engineVolume(engineVolume)
                .transmissionType(transmissionType)
                .releaseYear(releaseYear)
                .numberOfSeats(numberOfSeats)
                .build();

        return carService.searchCars(searchRequest).stream()
                .map(CarMapper::toCarDTO)
                .toList();
    }
}

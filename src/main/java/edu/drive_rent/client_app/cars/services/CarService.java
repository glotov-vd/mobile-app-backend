package edu.drive_rent.client_app.cars.services;

import edu.drive_rent.client_app.auth.models.User;
import edu.drive_rent.client_app.cars.controllers.dto.CarSearchRequest;
import edu.drive_rent.client_app.cars.models.Car;
import edu.drive_rent.client_app.cars.models.CarBrand;
import edu.drive_rent.client_app.cars.models.Comment;
import edu.drive_rent.client_app.cars.models.RentalRate;
import edu.drive_rent.client_app.cars.repositories.CarBrandRepository;
import edu.drive_rent.client_app.cars.repositories.CarRepository;
import edu.drive_rent.client_app.cars.repositories.CommentRepository;
import edu.drive_rent.client_app.cars.repositories.RentalRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final CarBrandRepository carBrandRepository;
    private final RentalRateRepository rentalRateRepository;
    private final CommentRepository commentRepository;


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

    public RentalRate getCarRental(String carId) {
        return rentalRateRepository.findByCarId(carId)
                .orElseThrow(() -> new RuntimeException("Car not found"));
    }

    public List<Comment> getAllCommentsForCar(String carId) {

        return commentRepository.findAll().stream()
                .filter(comment -> comment.getCarId().equals(carId))
                .toList();
    }

    public void addNewComment(User author, String carId, String comment) {

        var newComment = Comment.builder()
                .id(UUID.randomUUID().toString())
                .carId(carId)
                .author(author.getLastname() + ' ' + author.getFirstname().charAt(0) + '.')
                .text(comment)
                .build();

        commentRepository.save(newComment);
    }
}

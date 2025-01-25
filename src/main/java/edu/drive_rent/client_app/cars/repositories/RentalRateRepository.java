package edu.drive_rent.client_app.cars.repositories;

import edu.drive_rent.client_app.cars.models.RentalRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RentalRateRepository extends JpaRepository<RentalRate, String> {

    Optional<RentalRate> findByCarId(String carId);
}
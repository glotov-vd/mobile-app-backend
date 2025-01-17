package edu.drive_rent.client_app.cars.repositories;

import edu.drive_rent.client_app.cars.models.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarBrandRepository extends JpaRepository<CarBrand, Long> {
}
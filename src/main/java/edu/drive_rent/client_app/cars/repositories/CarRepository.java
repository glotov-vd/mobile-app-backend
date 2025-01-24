package edu.drive_rent.client_app.cars.repositories;

import edu.drive_rent.client_app.cars.models.Car;
import edu.drive_rent.client_app.cars.models.CarClazz;
import edu.drive_rent.client_app.cars.models.EngineType;
import edu.drive_rent.client_app.cars.models.TransmissionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {

    Optional<Car> findCarById(@Param("id") String id);

    @Query("""
            SELECT c FROM Car c
            WHERE (:brand IS NULL OR LOWER(c.brand.name) = LOWER(:brand))
            AND (:model IS NULL OR LOWER(c.model.name) = LOWER(:model))
            AND (:carClass IS NULL OR c.carClazz = :carClass)
            AND (:engineType IS NULL OR c.engineType = :engineType)
            AND (:enginePower IS NULL OR c.enginePower = :enginePower)
            AND (:engineVolume IS NULL OR c.engineVolume = :engineVolume)
            AND (:transmissionType IS NULL OR c.transmissionType = :transmissionType)
            AND (:releaseYear IS NULL OR c.releaseYear = :releaseYear)
            AND (:numberOfSeats IS NULL OR c.numberOfSeats = :numberOfSeats)
            """)
    List<Car> searchCars(
            @Param("brand") String brand,
            @Param("model") String model,
            @Param("carClass") CarClazz carClass,
            @Param("engineType") EngineType engineType,
            @Param("enginePower") Integer enginePower,
            @Param("engineVolume") Float engineVolume,
            @Param("transmissionType") TransmissionType transmissionType,
            @Param("releaseYear") Integer releaseYear,
            @Param("numberOfSeats") Integer numberOfSeats
    );
}

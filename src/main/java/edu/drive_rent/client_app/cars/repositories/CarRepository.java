package edu.drive_rent.client_app.cars.repositories;

import edu.drive_rent.client_app.cars.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {

    @Query("""
        SELECT c FROM Car c
        INNER JOIN c.brand b
        WHERE LOWER(b.name) = LOWER(:brand)
    """)
    List<Car> findAllByBrand(@Param("brand") String brand);

    @Query("""
        SELECT c FROM Car c
        INNER JOIN c.brand b
        INNER JOIN c.model m
        WHERE LOWER(b.name) = LOWER(:brand) AND LOWER(m.name) = LOWER(:model)
    """)
    List<Car> findAllByBrandAndModel(@Param("brand") String brand,
                                     @Param("model") String model);
}

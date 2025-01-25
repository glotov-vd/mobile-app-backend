package edu.drive_rent.client_app.cars.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "rental_rate")
public class RentalRate {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "car_id", nullable = false, length = 40)
    private String carId;

    @Column(name = "min_days", nullable = false)
    private Integer minDays;

    @Column(name = "max_days", nullable = false)
    private Integer maxDays;

    @Column(name = "price_per_day", nullable = false)
    private Float pricePerDay;
}

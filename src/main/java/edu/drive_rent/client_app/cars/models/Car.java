package edu.drive_rent.client_app.cars.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Car {

    @Id
    @Column(name = "id", length = 40)
    private String id;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id", nullable = false)
    private CarBrand brand;

    @ManyToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id", nullable = false)
    private CarModel model;

    @Enumerated(EnumType.STRING)
    @Column(name = "car_class", length = 15, nullable = false)
    private CarClazz carClazz;

    @Enumerated(EnumType.STRING)
    @Column(name = "engine_type", length = 15, nullable = false)
    private EngineType engineType;

    @Column(name = "engine_power", nullable = false)
    private int enginePower;

    @Column(name = "engine_volume", nullable = false)
    private float engineVolume;

    @Enumerated(EnumType.STRING)
    @Column(name = "transmission_type", length = 20, nullable = false)
    private TransmissionType transmissionType;

    @Column(name = "release_year", nullable = false)
    private int releaseYear;

    @Column(name = "number_of_seats", nullable = false)
    private int numberOfSeats;
}

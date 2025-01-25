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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    private String id;

    @Column(name = "car_id", nullable = false)
    private String carId;

    @Column(name = "author")
    private String author;

    @Column(name = "text")
    private String text;
}

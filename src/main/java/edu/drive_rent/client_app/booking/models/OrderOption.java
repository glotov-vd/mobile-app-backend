package edu.drive_rent.client_app.booking.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_options")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderOption {

    @Id
    @Column(name = "id", length = 40)
    private String id;

    @Column(name = "order_id", length = 40, nullable = false)
    private String orderId;

    @Column(name = "option_id", nullable = false)
    private int optionId;

    @Column(name = "quantity", nullable = false)
    private int quantity;
}

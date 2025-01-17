package edu.drive_rent.client_app.orders.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {

    PENDING("Ожидающий"),
    CONFIRMED("Подтвержденный"),
    CANCELED("Отмененный"),
    COMPLETED("Завершенный");

    private final String description;
}

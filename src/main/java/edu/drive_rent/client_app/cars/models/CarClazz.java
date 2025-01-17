package edu.drive_rent.client_app.cars.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CarClazz {

    SUV("Внедорожник"),
    SPORTS("Спорткар"),
    PREMIUM("Премиум"),
    BUSINESS("Бизнес"),
    MINIVAN("Минивэн"),
    COMFORT("Комфорт"),
    ELECTRIC_CAR("Электромобиль"),
    CONVERTIBLE("Кабриолет");

    private final String displayName;
}

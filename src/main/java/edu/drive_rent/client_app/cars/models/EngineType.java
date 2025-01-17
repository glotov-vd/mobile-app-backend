package edu.drive_rent.client_app.cars.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EngineType {

    GASOLINE("Бензиновый"),
    DIESEL("Дизельный"),
    ELECTRIC("Электрический"),
    HYBRID("Гибридный"),
    HYDROGEN("Водородный");

    private final String displayName;
}

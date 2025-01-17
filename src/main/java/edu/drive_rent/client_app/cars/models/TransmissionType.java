package edu.drive_rent.client_app.cars.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TransmissionType {

    MANUAL("Механическая"),
    AUTOMATIC("Автоматическая"),
    SEMI_AUTOMATIC("Полуавтоматическая"),
    CVT("Вариатор"),
    DUAL_CLUTCH("Роботизированная (двойное сцепление)");

    private final String displayName;
}

CREATE TABLE rental_rate
(
    id            VARCHAR(40) PRIMARY KEY, -- Уникальный идентификатор
    car_id        VARCHAR(40) NOT NULL,    -- Идентификатор автомобиля
    min_days      INT         NOT NULL,    -- Минимальное количество дней по тарифу
    max_days      INT         NOT NULL,    -- Максимальное количество дней по тарифу
    price_per_day FLOAT       NOT NULL,    -- Цена аренды за сутки
    CONSTRAINT fk_car_id FOREIGN KEY (car_id) REFERENCES cars (id) ON DELETE CASCADE
);

-- Вставка данных в таблицу car_rates для автомобилей Audi
INSERT INTO rental_rate (id, car_id, min_days, max_days, price_per_day)
VALUES (uuid_generate_v4(), (SELECT id FROM cars WHERE model_id = (SELECT id FROM car_models WHERE name = 'R8')), 1, 30,
        55000.00),
       (uuid_generate_v4(),
        (SELECT id FROM cars WHERE model_id = (SELECT id FROM car_models WHERE name = 'R8 V10 Cabrio')), 1, 30,
        65500.00),
       (uuid_generate_v4(), (SELECT id FROM cars WHERE model_id = (SELECT id FROM car_models WHERE name = 'RS6')), 1,
        30, 50000.00);

-- Вставка данных в таблицу car_rates для автомобилей BMW
INSERT INTO rental_rate (id, car_id, min_days, max_days, price_per_day)
VALUES (uuid_generate_v4(),
        (SELECT id FROM cars WHERE model_id = (SELECT id FROM car_models WHERE name = 'M4 Competition')), 1, 30,
        32000.00),
       (uuid_generate_v4(),
        (SELECT id FROM cars WHERE model_id = (SELECT id FROM car_models WHERE name = 'M850 i Cabrio')), 1, 30,
        54000.00),
       (uuid_generate_v4(), (SELECT id FROM cars WHERE model_id = (SELECT id FROM car_models WHERE name = 'X6M')), 1,
        30, 35000.00);

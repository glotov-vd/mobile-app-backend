DELETE FROM cars
WHERE brand_id IN (SELECT id FROM car_models WHERE name in ('A3', 'A4', 'A5', 'Q5', 'Q7', 'Q8', '320i', '330i', 'X3', 'X5', 'M5', 'i8'));

DELETE FROM car_models
WHERE name IN ('A3', 'A4', 'A5', 'Q5', 'Q7', 'Q8', '320i', '330i', 'X3', 'X5', 'M5', 'i8');

-- Вставка данных в таблицу car_models для бренда Audi
INSERT INTO car_models (name, brand_id)
VALUES ('R8', (SELECT id FROM car_brands WHERE name = 'Audi')),
       ('R8 V10 Cabrio', (SELECT id FROM car_brands WHERE name = 'Audi')),
       ('RS6', (SELECT id FROM car_brands WHERE name = 'Audi'));

-- Вставка данных в таблицу car_models для бренда BMW
INSERT INTO car_models (name, brand_id)
VALUES ('M4 Competition', (SELECT id FROM car_brands WHERE name = 'BMW')),
       ('M850 i Cabrio', (SELECT id FROM car_brands WHERE name = 'BMW')),
       ('X6M', (SELECT id FROM car_brands WHERE name = 'BMW'));

-- Вставка данных в таблицу cars для бренда Audi
INSERT INTO cars (id, brand_id, model_id, car_class, engine_type, engine_power, engine_volume, transmission_type,
                  release_year, number_of_seats)
VALUES (uuid_generate_v4(), (SELECT id FROM car_brands WHERE name = 'Audi'),
        (SELECT id FROM car_models WHERE name = 'R8'), 'SPORTS', 'GASOLINE', 610, 5.2, 'DUAL_CLUTCH', 2019, 2),
       (uuid_generate_v4(), (SELECT id FROM car_brands WHERE name = 'Audi'),
        (SELECT id FROM car_models WHERE name = 'R8 V10 Cabrio'), 'CONVERTIBLE', 'DIESEL', 620, 5.2, 'DUAL_CLUTCH', 2022, 2),
       (uuid_generate_v4(), (SELECT id FROM car_brands WHERE name = 'Audi'),
        (SELECT id FROM car_models WHERE name = 'RS6'), 'PREMIUM', 'GASOLINE', 640, 4.0, 'AUTOMATIC', 2019, 4);

-- Вставка данных в таблицу cars для бренда BMW
INSERT INTO cars (id, brand_id, model_id, car_class, engine_type, engine_power, engine_volume, transmission_type,
                  release_year, number_of_seats)
VALUES (uuid_generate_v4(), (SELECT id FROM car_brands WHERE name = 'BMW'),
        (SELECT id FROM car_models WHERE name = 'M4 Competition'), 'PREMIUM', 'GASOLINE', 510, 3.0, 'AUTOMATIC', 2021, 4),
       (uuid_generate_v4(), (SELECT id FROM car_brands WHERE name = 'BMW'),
        (SELECT id FROM car_models WHERE name = 'M850 i Cabrio'), 'CONVERTIBLE', 'GASOLINE', 530, 4.5, 'DUAL_CLUTCH', 2022, 4),
       (uuid_generate_v4(), (SELECT id FROM car_brands WHERE name = 'BMW'),
        (SELECT id FROM car_models WHERE name = 'X6M'), 'SUV', 'GASOLINE', 625, 4.4, 'AUTOMATIC', 2020, 5);
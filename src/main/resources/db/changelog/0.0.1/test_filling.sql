-- Вставка данных в таблицу car_brands
INSERT INTO car_brands (name)
VALUES ('Audi'),
       ('BMW');

-- Вставка данных в таблицу car_models для бренда Audi
INSERT INTO car_models (name, brand_id)
VALUES ('A3', (SELECT id FROM car_brands WHERE name = 'Audi')),
       ('A4', (SELECT id FROM car_brands WHERE name = 'Audi')),
       ('A5', (SELECT id FROM car_brands WHERE name = 'Audi')),
       ('Q5', (SELECT id FROM car_brands WHERE name = 'Audi')),
       ('Q7', (SELECT id FROM car_brands WHERE name = 'Audi')),
       ('Q8', (SELECT id FROM car_brands WHERE name = 'Audi'));

-- Вставка данных в таблицу car_models для бренда BMW
INSERT INTO car_models (name, brand_id)
VALUES ('320i', (SELECT id FROM car_brands WHERE name = 'BMW')),
       ('330i', (SELECT id FROM car_brands WHERE name = 'BMW')),
       ('X3', (SELECT id FROM car_brands WHERE name = 'BMW')),
       ('X5', (SELECT id FROM car_brands WHERE name = 'BMW')),
       ('M5', (SELECT id FROM car_brands WHERE name = 'BMW')),
       ('i8', (SELECT id FROM car_brands WHERE name = 'BMW'));

-- Вставка данных в таблицу cars для бренда Audi
INSERT INTO cars (id, brand_id, model_id, car_class, engine_type, engine_power, engine_volume, transmission_type,
                  release_year, number_of_seats)
VALUES (uuid_generate_v4(), (SELECT id FROM car_brands WHERE name = 'Audi'),
        (SELECT id FROM car_models WHERE name = 'A3'), 'COMFORT', 'GASOLINE', 150, 2.0, 'AUTOMATIC', 2020, 5),
       (uuid_generate_v4(), (SELECT id FROM car_brands WHERE name = 'Audi'),
        (SELECT id FROM car_models WHERE name = 'A4'), 'BUSINESS', 'DIESEL', 190, 2.0, 'AUTOMATIC', 2021, 5),
       (uuid_generate_v4(), (SELECT id FROM car_brands WHERE name = 'Audi'),
        (SELECT id FROM car_models WHERE name = 'A5'), 'SPORTS', 'GASOLINE', 220, 3.0, 'AUTOMATIC', 2022, 4),
       (uuid_generate_v4(), (SELECT id FROM car_brands WHERE name = 'Audi'),
        (SELECT id FROM car_models WHERE name = 'Q5'), 'SUV', 'HYBRID', 250, 2.5, 'AUTOMATIC', 2021, 5),
       (uuid_generate_v4(), (SELECT id FROM car_brands WHERE name = 'Audi'),
        (SELECT id FROM car_models WHERE name = 'Q7'), 'SUV', 'DIESEL', 280, 3.0, 'AUTOMATIC', 2020, 7),
       (uuid_generate_v4(), (SELECT id FROM car_brands WHERE name = 'Audi'),
        (SELECT id FROM car_models WHERE name = 'Q8'), 'SUV', 'ELECTRIC', 400, 0.0, 'AUTOMATIC', 2023, 5);

-- Вставка данных в таблицу cars для бренда BMW
INSERT INTO cars (id, brand_id, model_id, car_class, engine_type, engine_power, engine_volume, transmission_type,
                  release_year, number_of_seats)
VALUES (uuid_generate_v4(), (SELECT id FROM car_brands WHERE name = 'BMW'),
        (SELECT id FROM car_models WHERE name = '320i'), 'COMFORT', 'GASOLINE', 180, 2.0, 'AUTOMATIC', 2021, 5),
       (uuid_generate_v4(), (SELECT id FROM car_brands WHERE name = 'BMW'),
        (SELECT id FROM car_models WHERE name = '330i'), 'BUSINESS', 'DIESEL', 210, 2.0, 'AUTOMATIC', 2022, 5),
       (uuid_generate_v4(), (SELECT id FROM car_brands WHERE name = 'BMW'),
        (SELECT id FROM car_models WHERE name = 'X3'), 'SUV', 'GASOLINE', 250, 2.5, 'AUTOMATIC', 2020, 5),
       (uuid_generate_v4(), (SELECT id FROM car_brands WHERE name = 'BMW'),
        (SELECT id FROM car_models WHERE name = 'X5'), 'SUV', 'HYBRID', 300, 3.0, 'AUTOMATIC', 2021, 5),
       (uuid_generate_v4(), (SELECT id FROM car_brands WHERE name = 'BMW'),
        (SELECT id FROM car_models WHERE name = 'M5'), 'SPORTS', 'GASOLINE', 530, 4.4, 'DUAL_CLUTCH', 2022, 4),
       (uuid_generate_v4(), (SELECT id FROM car_brands WHERE name = 'BMW'),
        (SELECT id FROM car_models WHERE name = 'i8'), 'SPORTS', 'HYBRID', 370, 1.5, 'DUAL_CLUTCH', 2023, 2);
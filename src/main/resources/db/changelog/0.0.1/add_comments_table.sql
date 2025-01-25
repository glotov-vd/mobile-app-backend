CREATE TABLE comments
(
    id     VARCHAR(40) PRIMARY KEY, -- Уникальный идентификатор
    car_id VARCHAR(40)  NOT NULL,   -- Идентификатор автомобиля
    text   text         NOT NULL,   -- Текст отзыва
    author VARCHAR(255) NOT NULL,   -- Фамилия автора
    CONSTRAINT fk_car_id FOREIGN KEY (car_id) REFERENCES cars (id) ON DELETE CASCADE
);
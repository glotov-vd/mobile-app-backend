CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE car_brands
(
    id   serial PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);
COMMENT ON COLUMN car_brands.id IS 'Уникальный идентификатор';
COMMENT ON COLUMN car_brands.name IS 'Название бренда автомобиля (уникальное)';


CREATE TABLE car_models
(
    id       serial PRIMARY KEY,
    name     VARCHAR(250) NOT NULL,
    brand_id INTEGER      NOT NULL,
    FOREIGN KEY (brand_id) REFERENCES car_brands (id) ON DELETE CASCADE
);
COMMENT ON COLUMN car_models.id IS 'Уникальный идентификатор модели автомобиля';
COMMENT ON COLUMN car_models.name IS 'Название модели автомобиля';
COMMENT ON COLUMN car_models.brand_id IS 'Внешний ключ к таблице брендов (car_brands)';


CREATE TABLE cars
(
    id                VARCHAR(40) PRIMARY KEY,
    brand_id          INTEGER,
    model_id          INTEGER,
    car_class         VARCHAR(15) NOT NULL,
    engine_type       VARCHAR(15) NOT NULL,
    engine_power      INTEGER     NOT NULL,
    engine_volume     FLOAT       NOT NULL,
    transmission_type VARCHAR(20) NOT NULL,
    release_year      INTEGER     NOT NULL,
    number_of_seats   INTEGER     NOT NULL CHECK (number_of_seats >= 2 AND number_of_seats <= 9),
    FOREIGN KEY (brand_id) REFERENCES car_brands (id) ON DELETE CASCADE,
    FOREIGN KEY (model_id) REFERENCES car_models (id) ON DELETE CASCADE
);
COMMENT ON COLUMN cars.id IS 'Уникальный идентификатор (UUID) автомобиля';
COMMENT ON COLUMN cars.brand_id IS 'Внешний ключ к таблице брендов (car_brands)';
COMMENT ON COLUMN cars.model_id IS 'Внешний ключ к таблице моделей (car_models)';
COMMENT ON COLUMN cars.car_class IS 'Класс автомобиля (например, Comfort, Premium)';
COMMENT ON COLUMN cars.engine_type IS 'Тип двигателя (например, бензиновый, электрический)';
COMMENT ON COLUMN cars.engine_power IS 'Мощность двигателя в лошадиных силах';
COMMENT ON COLUMN cars.engine_volume IS 'Объем двигателя в кубических сантиметрах';
COMMENT ON COLUMN cars.transmission_type IS 'Тип коробки передач (автомат, механика и т.д.)';
COMMENT ON COLUMN cars.release_year IS 'Год выпуска автомобиля';
COMMENT ON COLUMN cars.number_of_seats IS 'Количество сидений (ограничение от 2 до 9)';


CREATE TABLE users
(
    id           VARCHAR(40) PRIMARY KEY,
    firstname    VARCHAR(255) NOT NULL,
    lastname     VARCHAR(255) NOT NULL,
    email        VARCHAR(255) NOT NULL UNIQUE,
    password     VARCHAR(255) NOT NULL,
    license_code VARCHAR(10)  NOT NULL,
    role         VARCHAR(255),
    create_date  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);
COMMENT ON COLUMN users.id IS 'Уникальный идентификатор пользователя (UUID)';
COMMENT ON COLUMN users.firstname IS 'Имя пользователя';
COMMENT ON COLUMN users.lastname IS 'Фамилия пользователя';
COMMENT ON COLUMN users.email IS 'Электронная почта пользователя (уникальная)';
COMMENT ON COLUMN users.password IS 'Пароль пользователя';
COMMENT ON COLUMN users.role IS 'Роль пользователя (Enum: например, ADMIN, USER)';
COMMENT ON COLUMN users.create_date IS 'Дата и время создания записи пользователя';


CREATE TABLE orders
(
    id           VARCHAR(40) PRIMARY KEY,
    car_id       VARCHAR(40) NOT NULL,
    client_id    VARCHAR(40) NOT NULL,
    order_date   DATE,
    start_date   DATE,
    end_date     DATE,
    order_status VARCHAR(20)
);
COMMENT ON COLUMN orders.id IS 'Уникальный идентификатор заказа';
COMMENT ON COLUMN orders.car_id IS 'Идентификатор автомобиля (ссылка на таблицу автомобилей)';
COMMENT ON COLUMN orders.client_id IS 'Идентификатор клиента (ссылка на таблицу клиентов)';
COMMENT ON COLUMN orders.order_date IS 'Дата создания заказа';
COMMENT ON COLUMN orders.start_date IS 'Дата начала аренды';
COMMENT ON COLUMN orders.end_date IS 'Дата окончания аренды';
COMMENT ON COLUMN orders.order_status IS 'Статус заказа (ожидающий, подтвержденный, отмененный, завершенный)';


CREATE TABLE options
(
    id          serial PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    description TEXT,
    price       FLOAT        NOT NULL
);
COMMENT ON COLUMN options.id IS 'Уникальный идентификатор дополнительной услуги';
COMMENT ON COLUMN options.name IS 'Название дополнительной услуги';
COMMENT ON COLUMN options.description IS 'Описание дополнительной услуги';
COMMENT ON COLUMN options.price IS 'Цена дополнительной услуги';

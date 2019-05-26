CREATE SCHEMA car_rent_storage;

CREATE TABLE car
(
  id     SERIAL PRIMARY KEY NOT NULL,
  brand  VARCHAR(50)        NOT NULL,
  model  VARCHAR(50)        NOT NULL,
  price  DOUBLE PRECISION   NOT NULL,
  status varchar(50)        NOT NULL,
  user_id INT REFERENCES car_rent_storage.users (id)
);

CREATE TABLE users
(
  id       SERIAL PRIMARY KEY NOT NULL,
  name     VARCHAR(50)        NOT NULL,
  username VARCHAR(50)        NOT NULL,
  password VARCHAR(50)        NOT NULL,
  role     varchar(5)         NOT NULL,
  order_id INT REFERENCES car_rent_storage.orders (id)
);

CREATE TABLE orders
(
  id                 SERIAL PRIMARY KEY,
  passport           VARCHAR(256)     NOT NULL,
  created            DATE             NOT NULL,
  date_from          DATE             NOT NULL,
  date_to            DATE             NOT NULL,
  status             VARCHAR(50)      NOT NULL,
  reject_reason      VARCHAR(250),
  damage_description VARCHAR(250),
  car_id INT REFERENCES car_rent_storage.car (id)
);

DROP TABLE car;
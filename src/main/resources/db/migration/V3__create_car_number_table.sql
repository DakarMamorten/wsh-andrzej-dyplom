CREATE TABLE car_number(
    id BIGSERIAL,
    registration_number VARCHAR,
    country_region VARCHAR,
    CONSTRAINT car_number_id_pk PRIMARY KEY (id)
);

INSERT INTO car_number(registration_number,country_region) VALUES ('AE','UA');

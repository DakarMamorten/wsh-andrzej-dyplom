CREATE TABLE car_number(
    id BIGSERIAL,
    reg_no VARCHAR,
    country_region VARCHAR,
    CONSTRAINT car_number_id_pk PRIMARY KEY (id)
);

INSERT INTO car_number(reg_no,country_region) VALUES ('AE','UA');

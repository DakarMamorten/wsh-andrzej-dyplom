CREATE TABLE car
(
    car_id              BIGSERIAL,
    reg_no              VARCHAR,
    country_reg         VARCHAR,
    brand               VARCHAR,
    model               VARCHAR,
    year_of_production  INTEGER,
    vin_number          VARCHAR,
    old_registry_number VARCHAR,
    CONSTRAINT car_pk_id PRIMARY KEY (car_id)
);
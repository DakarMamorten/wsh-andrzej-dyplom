CREATE TABLE car
(
    car_id             BIGSERIAL,
    regNo              BIGINT,
    full_name          VARCHAR,
    brand              VARCHAR,
    model              VARCHAR,
    year_of_production BIGINT,
    vin_number         BIGINT,
    oldRegistryNumber  VARCHAR
);
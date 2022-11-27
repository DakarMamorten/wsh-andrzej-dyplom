CREATE TABLE car
(
    car_id              BIGSERIAL,
    model               VARCHAR,
    car_number_id       BIGINT,
    brand               VARCHAR,
    year_of_production  INTEGER,
    vin_number          VARCHAR,
    old_registry_number VARCHAR,
    CONSTRAINT car_pk_id PRIMARY KEY (car_id),
    CONSTRAINT car_car_number_id_fk FOREIGN KEY (car_number_id)
        REFERENCES car_number
);

INSERT INTO car(model, car_number_id, brand, year_of_production, vin_number, old_registry_number)
VALUES ('Avensis', 1, 'TOYOTA', 2006, '123123WEf2123f', 'AE2343AC');
VALUES ('Golf', 1, 'VOLKSWAGEN', 2008, '87567554WEf2123f', 'AA2383AC');
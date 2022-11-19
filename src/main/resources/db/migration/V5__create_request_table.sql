CREATE TABLE request
(
    id          BIGSERIAL,
    car_id      BIGINT,
    user_id     BIGINT,
    status      VARCHAR,
    date_create TIMESTAMP,
    CONSTRAINT request_pk_id PRIMARY KEY (id),
    CONSTRAINT request_car_cer_id_fk FOREIGN KEY (car_id) REFERENCES car,
    CONSTRAINT request_user_user_id_fk FOREIGN KEY (user_id) REFERENCES users
);
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

INSERT INTO request(user_id, car_id,status, date_create)
VALUES (1, 1,'NEW','2022-11-19T11:34:05.764525200'), (2, 1,'APPROVED','2022-11-19T11:34:05.764525200'), (1, 1,'REJECTED','2022-11-19T11:34:05.764525200');
CREATE TABLE request
(
    id BIGSERIAL,
    car_id     BIGINT,
    user_id    BIGINT,
    CONSTRAINT request_pk_id PRIMARY KEY (id)
);
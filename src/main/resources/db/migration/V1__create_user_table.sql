CREATE TABLE users
(
    user_id  BIGSERIAL,
    role     VARCHAR,
    username VARCHAR,
    password VARCHAR,
    CONSTRAINT user_id_pk PRIMARY KEY (user_id)
);
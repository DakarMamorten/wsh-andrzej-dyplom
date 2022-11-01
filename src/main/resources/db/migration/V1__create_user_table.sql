CREATE TABLE users
(
    user_id  BIGSERIAL,
    role_id BIGINT,
    username varchar,
    password varchar,
    CONSTRAINT user_id_pk PRIMARY KEY (user_id),
    CONSTRAINT users_role_role_id_fk FOREIGN KEY (role_id)
    REFERENCES
);
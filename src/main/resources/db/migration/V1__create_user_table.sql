CREATE TABLE users
(
    user_id  BIGSERIAL,
    role     VARCHAR,
    username VARCHAR,
    password VARCHAR,
    CONSTRAINT user_id_pk PRIMARY KEY (user_id)
);


INSERT INTO users(role, username, password)
VALUES ('ROLE_ADMINISTRATOR','admin', '$2a$10$Otl968OQHaWTwCKiIh5jbe302pMePHaAbb8.fpGmk74zHWO1/IClm'), --gt64
       ('ROLE_USER','user1', '$2a$10$hUMIPiPljEb7SdjrcOs2Ce4NcjDJfY3C/QDH35pdNIeewis6op7ZC'), --user
       ('ROLE_USER','user2', '$2a$10$FXnpkQGqcNU.OQ5af.LlhelOZg44sYH8PRpT/24iDDAytr/T.vHjK'); --user
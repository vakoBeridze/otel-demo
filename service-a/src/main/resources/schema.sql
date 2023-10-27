CREATE SEQUENCE user_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE users
(
    id              BIGINT       DEFAULT NEXTVAL('user_id_seq') PRIMARY KEY,
    username        VARCHAR(100) NOT NULL,
    password        VARCHAR(250) NOT NULL
);
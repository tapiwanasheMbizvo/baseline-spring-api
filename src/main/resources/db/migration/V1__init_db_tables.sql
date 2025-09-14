CREATE SEQUENCE characters_seq START WITH 1 INCREMENT BY 1;


CREATE TABLE characters
(

    id        BIGINT PRIMARY KEY DEFAULT nextval('characters_seq'),
    firstName VARCHAR(100),
    lastName  VARCHAR(100),
    email     VARCHAR(100)
);


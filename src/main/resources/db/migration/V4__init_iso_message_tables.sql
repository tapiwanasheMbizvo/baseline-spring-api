CREATE SEQUENCE iso_message_seq START WITH 1 INCREMENT BY 1;


CREATE TABLE iso_messages
(

    id        BIGINT PRIMARY KEY DEFAULT nextval('iso_message_seq'),
    messageHeader VARCHAR(100),
    messageBody  VARCHAR(200)

);


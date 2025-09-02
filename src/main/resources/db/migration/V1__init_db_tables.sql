CREATE  TABLE characters(

    id INT GENERATED  ALWAYS  AS IDENTITY PRIMARY KEY ,
    firstName VARCHAR (100),
    lastName VARCHAR (100),
    email VARCHAR(100)
);


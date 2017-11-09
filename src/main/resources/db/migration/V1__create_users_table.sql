create table Users (
    ID bigserial not null primary key,
    username varchar(255) not null,
    surname varchar(255) not null,
    email varchar(100) not null,
    phone varchar(20),
    password varchar(255) not null,
    enabled boolean not null default 'true'
);
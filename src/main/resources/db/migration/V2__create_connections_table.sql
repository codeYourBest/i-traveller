create table Connections (
    ID bigserial not null primary key,
    from_place varchar(50) not null,
    to_place varchar(50) not null,
    valid_from date not null,
    valid_to date not null
);
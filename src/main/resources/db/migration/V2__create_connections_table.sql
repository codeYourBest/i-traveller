create table Connections (
    ID bigserial not null primary key,
    fromPlace varchar(50) not null,
    toPlace varchar(50) not null,
    validFrom date not null,
    validTo date not null
);
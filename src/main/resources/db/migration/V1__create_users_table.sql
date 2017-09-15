create table Users (
    ID bigserial not null primary key,
    Name varchar(50) not null,
    Surname varchar(50) not null,
    Email varchar(100) not null,
    Phone varchar(20) not null
);

insert into Users (Name, Surname, Email, Phone)
values ('Konrad', 'Laskoski', 'laska121@gmail.com', '111222333');

commit;
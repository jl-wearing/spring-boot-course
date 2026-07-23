create table if not exists purchase (
    id int unsigned auto_increment primary key,
    name varchar(25) not null,
    price decimal(9,2) not null
);
create table if not exists purchase (
    id int primary key auto_increment,
    product varchar(50) not null,
    price decimal(5,2) not null
    );
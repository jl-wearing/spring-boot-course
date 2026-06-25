create table if not exists account (
    id int primary key auto_increment,
    name varchar(50) not null,
    amount decimal(8,2) not null
);
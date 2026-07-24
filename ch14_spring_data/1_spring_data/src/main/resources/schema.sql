create table if not exists account (
    id int primary key auto_increment,
    name varchar(50) not null,
    amount decimal(11, 2) not null check (amount between 0 and 999999999)
);
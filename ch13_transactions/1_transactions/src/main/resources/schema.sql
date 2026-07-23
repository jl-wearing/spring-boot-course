create table if not exists accounts (
    id varchar(255) primary key,
    name varchar(100) not null,
    balance decimal(11,2) not null check (balance between 0 and 999999999.99)
);
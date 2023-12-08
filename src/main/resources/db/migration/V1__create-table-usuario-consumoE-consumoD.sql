create table usuario(
    id bigint not null auto_increment,
    nome varchar(255) not null,
    email varchar(255) not null unique,

    primary key(id)
);

create table consumoEnergetico(
    id bigint not null auto_increment,
    watts decimal(4,4) not null,
    billvalue decimal(10,2) not null,
    billmonth varchar(50) not null,

    primary key(id)
);

create table consumoAparelho(
    id bigint not null auto_increment,
    deviceConsume time not null,

    primary key(id)
);
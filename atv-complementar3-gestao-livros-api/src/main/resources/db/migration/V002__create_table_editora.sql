CREATE TABLE editora (
                         id int not null auto_increment,
                         nome varchar(60) not null,
                         email varchar(200) not null,
                         cidade varchar(60) not null,
                         estado varchar(02) not null,
                         primary key(id)
);
CREATE TABLE autor (
                       id int not null auto_increment,
                       nome varchar(60) not null,
                       email varchar(200) not null,
                       nacionalidade varchar(20),
                       primary key(id)
);
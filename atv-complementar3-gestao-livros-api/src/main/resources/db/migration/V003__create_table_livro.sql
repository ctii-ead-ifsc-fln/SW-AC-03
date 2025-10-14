CREATE TABLE livro (
                       id int not null auto_increment,
                       titulo varchar(100) not null,
                       isbn varchar(20),
                       preco_de_custo decimal(10,2) not null,
                       preco_de_venda decimal(10,2) not null,
                       margem_de_lucro decimal(10,2) not null,
                       data_de_cadastro date not null,
                       status enum('DISPONIVEL', 'ESGOTADO', 'BLOQUEADO') default 'DISPONIVEL',
                       id_editora int not null,
                       id_autor int not null,
                       primary key(id)
);

alter table livro add constraint fk_livro_autor
    foreign key(id_autor) references autor(id);

alter table livro add constraint fk_livro_editora
    foreign key(id_editora) references editora(id);
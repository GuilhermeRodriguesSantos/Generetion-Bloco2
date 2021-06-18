create database db_ecommerce;

use db_ecommerce;
/*Crie uma tabela produtos e utilizando a habilidade de abstração e determine 5 atributos
relevantes dos produtos para se trabalhar com o serviço deste ecommerce.*/


create table tb_produtos(
	id_Produto bigint(5) auto_increment,
    nome_Produto varchar(100) not null,
    quant_Produto int not null,
    preco_Produto decimal (10,2) not null,
    marca_Produto bigint(5),
    primary key(id_Produto)
);
create database db_escola;

/*Crie uma tabela estudantes e utilizando a habilidade de abstração e determine 5 atributos
relevantes dos estudantes para se trabalhar com o serviço dessa escola.*/

use db_escola;

create table tb_estudantes(
	id_Estudante bigint(5) auto_increment,
    nome_Estudante varchar(50) not null,
    idade_Estudante int not null,
    rg_Estudante varchar(9) not null,
    cpf_Estudante varchar(11) not null,
    nota_Estudante int not null,
    primary key(id_Estudante)
);

select * from tb_estudantes;
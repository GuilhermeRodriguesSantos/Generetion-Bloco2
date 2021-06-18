create database db_rh;

/*Crie uma tabela de funcionaries e utilizando a habilidade de abstração e determine 5
atributos relevantes dos funcionaries para se trabalhar com o serviço deste RH.
*/

use db_rh;

create table tb_funcionarios(
	id_Funcionario bigint  auto_increment,
    nome_Funcionario varchar(100) not null,
    idade_Funcionario int not null,
    salario_Funcionario decimal (10,2) not null,
    dtNascimento_Funcionario date,
    primary key (id_Funcionario)
)

use db_escola;

/*Faça um select que retorne o/as estudantes com a nota maior do que 7.
Faça um select que retorne o/as estudantes com a nota menor do que 7.
Ao término atualize um dado desta tabela através de uma query de atualização.*/

select * from tb_Estudantes where nota_Estudante > 7;
select * from tb_Estudantes where nota_Estudante < 7;

update tb_Estudantes set nome_Estudante = "Paola" where id_Estudante = 9;
select * from tb_Estudantes;
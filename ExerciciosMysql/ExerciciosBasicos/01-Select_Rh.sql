/*Faça um select que retorne os funcionaries com o salário maior do que 2000.
Faça um select que retorne os funcionaries com o salário menor do que 2000.
Ao término atualize um dado desta tabela através de uma query de atualização.*/

use db_rh;

select * from tb_funcionarios where salario_Funcionario > 2000;
select * from tb_funcionarios where salario_Funcionario < 2000;

update tb_funcionarios set nome_Funcionario = "João", salario_Funcionario = 1950.00
 where id_Funcionario = 5;
 
 select * from tb_funcionarios;
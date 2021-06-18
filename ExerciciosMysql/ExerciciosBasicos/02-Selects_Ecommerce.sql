/*Faça um select que retorne os produtos com o valor maior do que 500.
Faça um select que retorne os produtos com o valor menor do que 500.
Ao término atualize um dado desta tabela através de uma query de atualização.*/

use db_ecommerce;

select * from tb_produtos where preco_Produto > 500;
select * from tb_produtos where preco_Produto < 500;

update tb_produtos set nome_Produto = "gilete" where id_Produto = 7;
select * from tb_produtos;
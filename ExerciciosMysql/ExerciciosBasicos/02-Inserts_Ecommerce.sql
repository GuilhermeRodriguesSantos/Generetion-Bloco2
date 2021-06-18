/*Popule esta tabela com até 8 dados;*/

use db_ecommerce;

insert into tb_produtos (nome_Produto, quant_Produto, preco_Produto, marca_Produto)
	values("PS5",1,5000.0,1),
    ("XBOX-ONE", 1 , 3000, 2),
    ("tenis", 2 , 800, 3),
    ("TV", 1 , 2000, 1),
    ("celular", 1 , 400, 2),
    ("controle", 2 , 300, 2),
    ("prato", 2 , 100, 4),
    ("sandalha", 2 , 50, 5);
    
select * from tb_produtos;
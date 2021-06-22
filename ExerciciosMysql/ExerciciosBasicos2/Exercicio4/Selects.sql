USE db_cidade_das_carnes;

-- Faça um select que retorne os Produtos com o valor maior do que 50 reais.
SELECT nome_produto "Nome:", preco_produto "Preço:"FROM tb_produto 
	WHERE preco_produto > 50;

-- Faça um select trazendo os Produtos com valor entre 3 e 60 reais.
SELECT nome_produto "Nome:" , preco_produto"Preço:" 
	FROM tb_produto
    WHERE preco_produto >= 3 and preco_produto <= 60
    ORDER BY nome_produto ASC;

-- Faça um select utilizando LIKE buscando os Produtos com a letra C.
SELECT nome_produto "Nome:" FROM tb_produto
	WHERE nome_produto LIKE 'c%'
    ORDER BY nome_produto ASC;
    
-- Faça um um select com Inner join entre tabela categoria e produto.
SELECT * FROM tb_categoria
	INNER JOIN tb_produto ON tb_produto.fk_categoria = tb_categoria.id_categoria;

-- Faça um select onde traga todos os Produtos de uma categoria específica (exemplo todos os produtos que são aves ou legumes).
SELECT tb_produto.nome_produto "Nome:", tb_produto.preco_produto "Preço", tb_categoria.tipo_categoria "Categoria"
	FROM tb_produto
	INNER JOIN tb_categoria ON tb_categoria.id_categoria = tb_produto.fk_categoria
    WHERE tb_categoria.tipo_categoria = "Aves" or tb_categoria.tipo_categoria = "Legumes"
    ORDER BY tb_produto.nome_produto ASC;
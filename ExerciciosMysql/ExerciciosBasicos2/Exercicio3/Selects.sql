USE db_farmacia_do_bem;

-- Faça um select que retorne os Produtos com o valor maior do que 50 reais.
SELECT nome_produto "Nome:", preco_produto "Preço:"
 FROM tb_produto
 WHERE preco_produto > 50;
 
 -- Faça um select trazendo os Produtos com valor entre 3 e 60 reais.
 SELECT nome_produto "Nome:", preco_produto "Preço" FROM tb_produto
	WHERE preco_produto >= 3 AND preco_produto <= 60;

-- Faça um select utilizando LIKE buscando os Produtos com a letra B.
SELECT nome_produto "Nome:", preco_produto "Preco:" FROM tb_produto
	WHERE nome_produto LIKE 'b%'
    ORDER BY nome_produto ASC;

-- Faça um um select com Inner join entre tabela categoria e produto.
SELECT * FROM tb_categoria
	INNER JOIN tb_produto ON tb_produto.fk_categoria = tb_categoria.id_categoria;

-- Faça um select onde traga todos os Produtos de uma categoria específica (exemplo todos os produtos que são cosméticos).
SELECT tb_produto.nome_produto "Nome:", tb_produto.preco_produto "Preço:", tb_categoria.tipo_categoria
	FROM tb_produto
	INNER JOIN tb_categoria ON tb_categoria.id_categoria = tb_produto.fk_categoria
    WHERE tb_categoria.tipo_categoria = "cosmeticos"
    ORDER BY tb_produto.nome_produto ASC;
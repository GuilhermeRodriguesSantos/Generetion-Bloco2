USE db_pizzaria_legal;

-- Faça um select que retorne os Produtos com o valor maior do que 45 reais.
SELECT nome_pizza "Nome: " , preco_pizza "Preço: "  FROM tb_pizza
	WHERE preco_pizza > 45;

-- Faça um select trazendo os Produtos com valor entre 29 e 60 reais.
SELECT  nome_pizza "Nome: ", preco_pizza "Preço" FROM tb_pizza
	WHERE preco_pizza >= 29 AND preco_pizza <= 60
    ORDER BY preco_pizza ASC;

-- Faça um select utilizando LIKE buscando os Produtos com a letra C.
SELECT * FROM tb_pizza
	WHERE nome_pizza LIKE 'c%'
    ORDER BY nome_pizza ASC;

-- Faça um um select com Inner join entre tabela categoria e pizza.
SELECT * FROM tb_categoria
	INNER JOIN tb_pizza ON tb_pizza.fk_categoria = tb_categoria.id_categoria;

-- Faça um select onde traga todos os Produtos de uma categoria específica (exemplo todos os produtos que são pizza doce).
SELECT tb_pizza.nome_pizza "Nome: ", tb_pizza.preco_pizza "Preço: " , tb_pizza.validade "Validade", tb_categoria.tipo_categoria "Categoria: "
	FROM tb_pizza
	INNER JOIN tb_categoria ON tb_categoria.id_categoria = tb_pizza.fk_categoria
    WHERE tb_categoria.tipo_categoria = "Salgado"
    ORDER BY tb_pizza.nome_pizza ASC;
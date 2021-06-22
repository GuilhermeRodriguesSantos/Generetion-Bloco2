USE db_cidade_das_carnes;

INSERT INTO tb_categoria(tipo_categoria, estoque)
	VALUES
    ("Aves", true),
    ("Legumes", true),
    ("Carne", true),
    ("Frutas", true),
    ("Doces", true);
    
SELECT * FROM tb_categoria;

INSERT INTO tb_produto(nome_produto, preco_produto, validade, fk_categoria)
	VAlUES
    ("Castanha", 5.78, '2021-06-22', 2),
    ("Corvo", 55.32, '2021-06-22', 1),
    ("Manga", 15.78, '2021-06-22', 1),
    ("Castanha", 5.78, '2021-06-22', 1),
    ("Costela", 85.18, '2021-06-22', 3),
    ("Uva", 2.21, '2021-06-22', 4),
    ("Caramelo", 1.99, '2021-06-22', 5),
    ("Abacaxi", 13.25, '2021-06-22', 3);
    
SELECT * FROM tb_produto;
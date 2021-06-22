USE db_pizzaria_legal;


INSERT INTO tb_categoria(tipo_categoria, quantidade)
	VALUES
    ("Doce", 60),
    ("Salgado", 60),
    ("Dupla", 60),
    ("Tripla", 60),
    ("Familia", 60);
    
SELECT * FROM tb_categoria;

INSERT INTO tb_pizza(nome_pizza,preco_pizza,estoque_pizza,validade,fk_categoria)
	VALUES
	("Mussarela", 47.80, TRUE, '2021-05-20', 2),
    ("Catupiry", 42.80, TRUE, '2021-04-20', 2),
    ("Calabresa", 22.20, TRUE, '2021-02-12', 2),
    ("Cocholate", 30.10, TRUE, '2021-05-20', 1),
    ("Morango", 27.40, TRUE, '2021-05-22', 1),
    ("Quatro queijos", 20.80, TRUE, '2021-05-20', 3),
    ("Marguerita", 17.80, TRUE, '2021-09-07', 4),
    ("Portuguesa", 19.30, TRUE, '2021-03-10', 5);
    
SELECT * FROM tb_pizza;
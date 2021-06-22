USE db_farmacia_do_bem;

INSERT INTO tb_categoria(tipo_categoria, Quantidade)
	VALUES
    ("Cosmeticos",30),
    ("Esencia" , 20),
    ("Frascos", 25),
    ("Tecidos", "20"),
    ("Desodorantes", 30);
    
SELECT * FROM tb_categoria;

INSERT INTO tb_produto(nome_produto,preco_produto,estoque,validade,fk_categoria)
	VALUES
    ("Barbeador", 40, TRUE, '2025-11-02',1),
    ("Perfume", 20, TRUE, '2025-11-02',1),
    ("Besetacil", 10, TRUE, '2025-10-11',1),
    ("Frauda", 80, TRUE, '2025-11-02',3),
    ("Gilete", 11, TRUE, '2025-11-02',4),
    ("BrestorBarba", 30, TRUE, '2025-11-02',5),
    ("Gel", 9, TRUE, '2025-11-02',2),
    ("Remedios", 4, TRUE, '2025-11-02',1);
    
SELECT * FROM tb_produto;
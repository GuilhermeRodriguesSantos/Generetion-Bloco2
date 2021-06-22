USE db_construindo_a_nossa_vida;

INSERT INTO tb_categoria(tipo_categoria, ativo, data_inicio)
	VALUES
    ("Hidraulica", TRUE, '2021-06-21'),
    ("eolica", TRUE, '2021-06-21'),
    ("hidrogenia", TRUE, '2021-06-21'),
    ("Petroleo", TRUE, '2021-06-21'),
    ("Ferro", TRUE, '2021-06-21');

SELECT * FROM tb_categoria;

INSERT INTO tb_produto(nome_produto, preco_produto, data_vencimento, quantidade_estoque, fk_categoria)
	VALUES
    ("Tomada", 50.25, '2022-08-22', 5, 1),
    ("Cano", 20.25, '2022-08-22', 5, 2),
    ("ferro", 31.12, '2022-08-22', 5, 3),
    ("Ventilador", 20.25, '2022-08-22', 3, 3),
    ("Carro", 5120.25, '2022-08-22', 5, 2),
    ("Pano", 30.11, '2022-08-22', 7, 4),
    ("Tinta", 11.30, '2022-08-22', 4, 5),
    ("Lapiz", 2.25, '2022-08-22', 8, 1);
  
SELECT * FROM tb_produto;
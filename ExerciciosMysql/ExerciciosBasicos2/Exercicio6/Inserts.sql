USE db_cursoDaMinhaVida;

INSERT INTO tb_categoria(tipo_categoria, dt_inicio)
	VALUES
    ("Java", '2021-08-18'),
    ("JavaScript", '2021-08-18'),
    ("C", '2021-08-18');

SELECT * FROM tb_categoria;

INSERT INTO tb_produto(nome_produto, preco_produto, dt_termino, fk_categoria)
	VALUES
    ("CursoJava", 25.55, '2021-12-22', 1),
    ("CursoJavaScript", 35.55, '2021-12-22', 2),
    ("CursoC", 15.55, '2021-12-22', 3),
    ("CursoJavaBanco", 45.55, '2021-12-22', 1),
    ("CursoJavaScrpitNode", 23.15, '2021-12-22', 2),
    ("CursoCStruct", 10.59, '2021-12-22', 3),
    ("CursoJavaFor", 22.55, '2021-12-22', 1),
    ("CursoJavaScriptVetor", 55.55, '2021-12-22', 2);

SELECT * FROM tb_produto;
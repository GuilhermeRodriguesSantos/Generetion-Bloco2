CREATE DATABASE db_farmacia_do_bem;
USE db_farmacia_do_bem;

CREATE TABLE tb_categoria(
	id_categoria INT NOT NULL AUTO_INCREMENT,
    tipo_categoria VARCHAR(255) NOT NULL,
    Quantidade INT NOT NULL,
    PRIMARY KEY(id_categoria)
);

CREATE TABLE tb_produto(
	id_produto INT NOT NULL AUTO_INCREMENT,
    nome_produto VARCHAR(255) NOT NULL,
    preco_produto FLOAT NOT NULL,
    estoque BOOLEAN NOT NULL,
    validade DATE,
    fk_categoria INT NOT NULL,
    PRIMARY KEY (id_produto),
    FOREIGN KEY (fk_categoria) REFERENCES tb_categoria (id_categoria)
);
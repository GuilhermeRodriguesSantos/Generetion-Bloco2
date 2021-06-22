CREATE DATABASE db_pizzaria_legal;
USE db_pizzaria_legal;

CREATE TABLE tb_categoria(
	id_categoria INT NOT NULL AUTO_INCREMENT,
    tipo_categoria VARCHAR(255) NOT NULL,
    quantidade int not null,
	PRIMARY KEY(id_categoria)
);

CREATE TABLE tb_pizza(
	id_pizza INT NOT NULL AUTO_INCREMENT,
    nome_pizza VARCHAR(255) NOT NULL,
    preco_pizza FLOAT NOT NULL,
    estoque_pizza BOOLEAN NOT NULL,
    validade DATE NOT NULL,
    fk_categoria INT NOT NULL,
    PRIMARY KEY (id_pizza),
    FOREIGN KEY(fk_categoria) REFERENCES tb_categoria(id_categoria)
);
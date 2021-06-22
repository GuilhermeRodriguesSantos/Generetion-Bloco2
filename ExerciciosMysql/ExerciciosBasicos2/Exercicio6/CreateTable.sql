CREATE DATABASE db_cursoDaMinhaVida;
USE db_cursoDaMinhaVida;

CREATE TABLE tb_categoria(
	id_categoria INT NOT NULL AUTO_INCREMENT,
    tipo_categoria VARCHAR(255) NOT NULL,
    dt_inicio date NOT NULL,
    PRIMARY KEY(id_categoria)
);

CREATE TABLE tb_produto(
	id_produto INT NOT NULL AUTO_INCREMENT,
    nome_produto VARCHAR(255) NOT NULL,
    preco_produto FLOAT NOT NULL,
    dt_termino DATE NOT NULL,
    fk_categoria INT,
    PRIMARY KEY(id_produto),
    FOREIGN KEY(fk_categoria) REFERENCES tb_categoria(id_categoria)
);
CREATE DATABASE db_construindo_a_nossa_vida;
USE db_construindo_a_nossa_vida;

CREATE TABLE tb_categoria(
	id_categoria INT NOT NULL AUTO_INCREMENT,
    tipo_categoria VARCHAR(255) NOT NULL,
    ativo BOOLEAN NOT NULL,
    data_inicio DATE NOT NULL,
    PRIMARY KEY(id_categoria)
);

CREATE TABLE tb_produto(
	id_produto INT NOT NULL AUTO_INCREMENT,
    nome_produto VARCHAR (255) NOT NULL,
    preco_produto FLOAT NOT NULL,
    data_vencimento DATE NOT NULL,
    quantidade_estoque INT NOT NULL,
    fk_categoria INT NOT NULL,
    PRIMARY KEY (id_produto),
    FOREIGN KEY (fk_categoria) REFERENCES tb_categoria (id_categoria)
);
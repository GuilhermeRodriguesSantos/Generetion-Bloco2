/*------Criando o Banco do Projeto_Integrador------*/
CREATE DATABASE db_projeto_integrador;
USE db_projeto_integrador;

-- Criando as tabelas

CREATE TABLE tb_categoria(
	id_categoria INT NOT NULL AUTO_INCREMENT,
    categoria_sustentavel VARCHAR (255) NOT NULL,
    categoria_ranking INT NOT NULL,
    categoria_doacao VARCHAR(255) NOT NULL,
    PRIMARY KEY(id_categoria)
);

CREATE TABLE tb_produto(
	id_produto INT NOT NULL AUTO_INCREMENT,
    produto_nome VARCHAR(45) NOT NULL,
    produto_preco DECIMAL (10,2) NOT NULL,
    produto_descricao VARCHAR(255) NOT NULL,
    produto_quantidade INT NOT NULL,
    fk_categoria INT,
    produto_url VARCHAR(255) NOT NULL,
    PRIMARY KEY (id_produto),
    FOREIGN KEY (fk_categoria) REFERENCES tb_categoria (id_categoria)
);

CREATE TABLE tb_usuario(
	id_usuario INT NOT NULL AUTO_INCREMENT,
    nome_completo VARCHAR(255) NOT NULL,
    email VARCHAR (255) NOT NULL,
    senha VARCHAR (255) NOT NULL,
    PRIMARY KEY(id_usuario)
);

CREATE TABLE tb_venda_produto(
	fk_usuario INT,
    fk_categoria INT,
    FOREIGN KEY (fk_usuario) REFERENCES tb_usuario (id_usuario),
    FOREIGN KEY (fk_categoria) REFERENCES tb_categoria (id_categoria) 
);

/*-----FIMMM--------*/


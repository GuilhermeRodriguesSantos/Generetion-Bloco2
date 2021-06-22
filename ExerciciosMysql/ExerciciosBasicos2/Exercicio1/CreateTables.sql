-- CRIAÇÃO DO BANCO --
CREATE DATABASE db_generation_game_online;
USE db_generation_game_online;

/*------------ Criação das tabelas ----------------*/
CREATE TABLE tb_classe(
	id_classe INT NOT NULL AUTO_INCREMENT,
	tipo_classe VARCHAR(255) NOT NULL,
    sexo_classe VARCHAR(255) NOT NULL,
    PRIMARY KEY (id_classe)
);

CREATE TABLE tb_personagem(
	id_personagem INT NOT NULL AUTO_INCREMENT,
    nome_personagem VARCHAR(255) NOT NULL,
	poder_ataque INT NOT NULL,
    poder_defesa INT NOT NULL,
    pontos_de_vida INT NOT NULL,
    cor_personagem VARCHAR(255) NOT NULL,
    fk_classe INT,
    PRIMARY KEY(id_personagem),
    FOREIGN KEY(fk_classe) REFERENCES tb_classe(id_classe)
);
/*----------- Fim da criação das tabelas --------------*/
/*----- Inserindo dados na tabela -------*/
USE db_generation_game_online;


INSERT INTO tb_classe(tipo_classe, sexo_classe)
	VALUES
	("Arqueiro", "Masculino"),
    ("Guerreira", "Feminino"),
    ("Magico", "Masculino"),
    ("Curadeira", "Feminino"),
    ("REconstrutor", "Masculino");
    
   
/*-------------------------*/
INSERT INTO tb_personagem(nome_personagem,poder_ataque,poder_defesa,pontos_de_vida,cor_personagem,fk_classe)
	values 
    ("Marcos", 3000,1500,400,"azul",1),
    ("Carlos", 2100,1700,200,"preto",1),
    ("Camila", 4000,1900,300,"azul",1),
    ("Cassiane", 1500,1820,400,"Branca",2),
    ("Vinicius", 1000,2500,400,"azul",3),
    ("Guilherme", 4000,2500,600,"azul",1),
    ("Maria", 1000,3500,200,"Vermelho",4),
    ("Pedro", 2000,2000,300,"Preto",5);
    
SELECT * FROM tb_personagem;

UPDATE tb_classe set tipo_classe = "Reconstrutor" where id_classe = 5;  

SELECT * FROM tb_classe; 

/*--------------Fim-----------------
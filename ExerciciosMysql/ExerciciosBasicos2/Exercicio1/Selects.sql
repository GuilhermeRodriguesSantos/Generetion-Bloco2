/*------------- fazendo os selects --------*/

USE db_generation_game_online;

-- Faça um select que retorne os personagens com o poder de ataque maior do que 2000.
SELECT nome_personagem, poder_ataque FROM tb_personagem 
	WHERE poder_ataque > 2000;

-- Faça um select trazendo os personagens com poder de defesa entre 1000 e 2000.
SELECT nome_personagem "Nome" , poder_defesa "Defesa" FROM tb_personagem 
	WHERE poder_defesa >= 1000 AND poder_defesa <= 2000;

-- Faça um select utilizando LIKE buscando os personagens com a letra C.
SELECT nome_personagem "Nome:" FROM tb_personagem 
	WHERE nome_personagem  LIKE 'C%';
    
-- Faça um um select com Inner join entre tabela classe e personagem.
SELECT * FROM tb_classe
	INNER JOIN tb_personagem ON tb_personagem.fk_classe = tb_classe.id_classe
    ORDER BY nome_personagem ASC;

-- Faça um select onde traga todos os personagem de uma classe específica (exemplo todos os personagens que são arqueiros).
SELECT tb_personagem.nome_personagem "Nome:", tb_classe.tipo_classe "Categoria:" 
	FROM tb_personagem
	INNER JOIN tb_classe ON tb_classe.id_classe = tb_personagem.fk_classe
    WHERE tb_classe.tipo_classe = "Arqueiro"
    ORDER BY tb_personagem.nome_personagem ASC;
/*Popule esta tabela com até 8 dados;*/

use db_escola;

insert into tb_estudantes(nome_Estudante, idade_Estudante, rg_Estudante, cpf_Estudante, nota_Estudante)
	values("Guilherme", 19, "395874159", "58789654789", 8),
    ("Paulo", 20,  "325874159", "48789654789", 7),
    ("maria", 19,  "395874159", "58789654789", 9),
    ("joão", 19,   "395874159", "78956412365", 10),
    ("Felipe", 19, "257894578", "78965456987", 5),
    ("Carlos", 19, "789563277", "21457896523", 6),
    ("Amanda", 19, "789654236", "10254789632", 4),
    ("Josefa", 19, "202478965", "98745632147", 8),
    ("Paula", 19,  "123456789", "02487978745", 4);
    
select * from tb_estudantes;    
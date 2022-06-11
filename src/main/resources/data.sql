------------------------------------------------------------------------------------------------------------------------
--      OBJETIVOS
------------------------------------------------------------------------------------------------------------------------
INSERT INTO OBJETIVO (ID, ARRECADADO, DESCRICAO, PORCENTAGEM, PRAZO, TITULO, VALOR, DATA_CRIACAO, ATIVO)VALUES (1,0,'Descrição do Objetivo',0,'2022-09-15','Título do Objetivo',100, '2022-02-01', true);
INSERT INTO OBJETIVO (ID, ARRECADADO, DESCRICAO, PORCENTAGEM, PRAZO, TITULO, VALOR, DATA_CRIACAO, ATIVO)VALUES (2,8386.9,'Comprar um Honda Fit 2005 Automático',45,'2022-04-30','Veículo',18637.55, '2022-02-01', true);
INSERT INTO OBJETIVO (ID, ARRECADADO, DESCRICAO, PORCENTAGEM, PRAZO, TITULO, VALOR, DATA_CRIACAO, ATIVO)VALUES (3,3327.33,'Comprar um PlayStation 5 Digital Edition',70,'2022-12-25','Videogame',4753.33, '2022-02-01', true);
INSERT INTO OBJETIVO (ID, ARRECADADO, DESCRICAO, PORCENTAGEM, PRAZO, TITULO, VALOR, DATA_CRIACAO, ATIVO)VALUES (4,6393.15,'Viagem para Disney',90,'2023-01-25','Viagem',7103.50, '2022-02-01', true);
INSERT INTO OBJETIVO (ID, ARRECADADO, DESCRICAO, PORCENTAGEM, PRAZO, TITULO, VALOR, DATA_CRIACAO, ATIVO)VALUES (5,945.15,'Comprar Smart TV Samsung 55 polegadas ',25,'2022-06-01','Televisão',3780.6, '2022-02-01', true);
INSERT INTO OBJETIVO (ID, ARRECADADO, DESCRICAO, PORCENTAGEM, PRAZO, TITULO, VALOR, DATA_CRIACAO, ATIVO)VALUES (6,4181.23,'Notebook Dell Inspiron G3 15 polegadas, 16GB RAM, 1TB HD',82,'2022-05-26','Notebook',5099.06, '2022-02-01', true);

--OBJETIVO      TOTAL     ARRECADADO        RESTANTE    PORCENTAGEM
--Veículo		18637,55  8386,90           10250,65    45
--Vídeogame 	4753,33   3327,33           1426        70
--Viagem		7103,50   6393,15           710,35      90
--Televisão	    3780,60   945,15            2835,45     25
--Notebook	    5099,06   4181,23           917,83      82

------------------------------------------------------------------------------------------------------------------------
--      CATEGORIA
------------------------------------------------------------------------------------------------------------------------

INSERT INTO CATEGORIA (ID,ATIVO, DATA_CRIACAO, NOME) VALUES (1,true,'2022-01-31','Transporte');
INSERT INTO CATEGORIA (ID,ATIVO, DATA_CRIACAO, NOME) VALUES (2,true, '2022-01-31', 'Saúde');
INSERT INTO CATEGORIA (ID,ATIVO, DATA_CRIACAO, NOME) VALUES (3,true, '2022-01-31', 'Alimentação');
INSERT INTO CATEGORIA (ID,ATIVO, DATA_CRIACAO, NOME) VALUES (4,true, '2022-01-31', 'Lazer');
INSERT INTO CATEGORIA (ID,ATIVO, DATA_CRIACAO, NOME) VALUES (5,true, '2022-01-31', 'Vestuário');
INSERT INTO CATEGORIA (ID,ATIVO, DATA_CRIACAO, NOME) VALUES (6,true, '2022-01-31', 'Impostos');
INSERT INTO CATEGORIA (ID,ATIVO, DATA_CRIACAO, NOME) VALUES (7,true, '2022-01-31', 'Viagem');
INSERT INTO CATEGORIA (ID,ATIVO, DATA_CRIACAO, NOME) VALUES (8,false, '2022-01-31', 'Desativado');

------------------------------------------------------------------------------------------------------------------------
--      USUARIO
------------------------------------------------------------------------------------------------------------------------

INSERT INTO USUARIO (ID, EMAIL, NOME, SENHA, ATIVO, DATA_CRIACAO) VALUES (1,'joao@email.com','João','1234', true, '2022-02-01');
INSERT INTO USUARIO (ID, EMAIL, NOME, SENHA, ATIVO, DATA_CRIACAO) VALUES (2,'maria@email.com','Maria','1234', true, '2022-02-01');

------------------------------------------------------------------------------------------------------------------------
--      RECEITA
------------------------------------------------------------------------------------------------------------------------

INSERT INTO RECEITA (ID, DATA, DESCRICAO, VALOR, ATIVO, DATA_CRIACAO) VALUES (1,'2022-01-30','Vale de Janeiro','831.24', true, '2022-02-01');
INSERT INTO RECEITA (ID, DATA, DESCRICAO, VALOR, ATIVO, DATA_CRIACAO) VALUES (2,'2022-02-15','Salário Fevereiro','2497.53', true, '2022-02-01');

------------------------------------------------------------------------------------------------------------------------
--      DESPESA
------------------------------------------------------------------------------------------------------------------------

INSERT INTO DESPESA (ID, DESCRICAO, DT_VENCIMENTO, NOME_RESPONSAVEL, PARCELAS, REPETIR, VALOR, CATEGORIA_ID, ATIVO, DATA_CRIACAO) VALUES (1, 'Água', '2022-01-25', 'João', 0, 'NAO_REPETIR', 50.36, 6, true, '2022-02-01');
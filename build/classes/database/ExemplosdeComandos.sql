SELECT * FROM carros;

SELECT 
	nome, fabricante AS 'fabricante', 
	cor AS 'cor', 
quantidade_portas AS 'quantidade de portas'
FROM carros;

INSERT INTO carros 
(id,nome ,cor ,fabricante ,placa ,chassi ,quilometragem ,potencia ,data_compra ,esta_funcionando ,permitida_circulacao ,quantidade_portas 
,quantidade_batidas ,ano_fabricacao ,ano_lancamento ,tipo_pneu ,renavam, descricao)  
VALUE 
(1, "Gol", "Azul bebê", "VW", "ABC-2000", "16aSSh8273812", 29134741, 85,
'2017-08-07', TRUE, FALSE,
 4, 0, 2017, 2016, 175, 847516874, "");

INSERT INTO carros 
(nome ,cor ,fabricante ,potencia ,data_compra)  
VALUE 
("Palio", "rosa", "Fiat", 65, '2013-04-29');

SELECT COUNT(*) FROM carros;

TRUNCATE carros;

INSERT INTO carros (fabricante,cor, nome)
values
("VW","roxo", "golf"),
("VW","vermelho", "jetta"),
("VW","amarelo", "saveiro"),
("VW","azul", "fusca"),
("VW","preto", "novo fusca"),
("VW","verde", "kombi"),
("VW","cinza", "bora")

SELECT id, nome, quantidade_batidas
FROM carros
WHERE id > 4;

SELECT id, nome, quantidade_batidas
FROM carros
WHERE id >= 4;

SELECT id, nome, quantidade_batidas
FROM carros
WHERE id < 4;

SELECT id, nome, quantidade_batidas
FROM carros
WHERE id <= 4;

SELECT id, nome, quantidade_batidas
FROM carros
WHERE id <> 4;

SELECT fabricante, nome, cor  FROM carros 
ORDER BY fabricante ASC,
		nome ASC,
		cor ASC;


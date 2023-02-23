#создаем базы данных:
DROP DATABASE IF EXISTS human_friend;
CREATE DATABASE human_friend;
USE human_friend;

#создаем таблицу принадлежности к группе домашних животных:

DROP TABLE IF EXISTS animal_group;
CREATE TABLE animal_group (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    group_name VARCHAR(50)
);

INSERT INTO animal_group (group_name)
VALUES ('domestiс_aminals'),
	   ('pack animals');

#создаем таблицу принадлежности к типу животного:

DROP TABLE IF EXISTS animal_type;
CREATE TABLE animal_type (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    type_name VARCHAR(50)
);

INSERT INTO animal_type (type_name)
VALUES ('cat'),
	   ('dog'),
	   ('humster'),
	   ('horse'),
	   ('donkey'),
	   ('camel');
	  	  
#создаем таблицу умений:

DROP TABLE IF EXISTS skill;
CREATE TABLE skill (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    skill VARCHAR(50)
);

INSERT INTO skill (skill)
VALUES ('лаять'),
	   ('мяукать'),
	   ('грызть'),
	   ('бегать'),
	   ('кушать'),
	   ('иакать'),
	   ('жевать'),
	   ('скакать'),
	   ('плеваться'),
	   ('возить верхом');

	  
	  
#создаем низкоуравневые таблицы Cat:

DROP TABLE IF EXISTS cat;
CREATE TABLE cat (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    petname VARCHAR(50) COMMENT 'кличка',
    birthdate DATE,
    group_id INT UNSIGNED NOT NULL DEFAULT 1,
    type_id INT UNSIGNED NOT NULL DEFAULT 1,
	FOREIGN KEY (group_id) REFERENCES animal_group(id),
    FOREIGN KEY (type_id) REFERENCES animal_type(id)
);

#создаем низкоуравневые таблицы Dog:

DROP TABLE IF EXISTS dog;
CREATE TABLE dog (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    petname VARCHAR(50) COMMENT 'кличка',
    birthdate DATE,
    group_id INT UNSIGNED NOT NULL DEFAULT 1,
    type_id INT UNSIGNED NOT NULL DEFAULT 2,
	FOREIGN KEY (group_id) REFERENCES animal_group(id),
    FOREIGN KEY (type_id) REFERENCES animal_type(id)
);

#создаем низкоуравневые таблицы Humster:

DROP TABLE IF EXISTS humster;
CREATE TABLE humster (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    petname VARCHAR(50) COMMENT 'кличка',
    birthdate DATE,
    group_id INT UNSIGNED NOT NULL DEFAULT 1,
    type_id INT UNSIGNED NOT NULL DEFAULT 3,
	FOREIGN KEY (group_id) REFERENCES animal_group(id),
    FOREIGN KEY (type_id) REFERENCES animal_type(id)
);

#создаем низкоуравневые таблицы Horse:

DROP TABLE IF EXISTS horse;
CREATE TABLE horse (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    petname VARCHAR(50) COMMENT 'кличка',
    birthdate DATE,
    group_id INT UNSIGNED NOT NULL DEFAULT 2,
    type_id INT UNSIGNED NOT NULL DEFAULT 4,
	FOREIGN KEY (group_id) REFERENCES animal_group(id),
    FOREIGN KEY (type_id) REFERENCES animal_type(id)
);

#создаем низкоуравневые таблицы Donkey:

DROP TABLE IF EXISTS donkey;
CREATE TABLE donkey (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    petname VARCHAR(50) COMMENT 'кличка',
    birthdate DATE,
    group_id INT UNSIGNED NOT NULL DEFAULT 2,
    type_id INT UNSIGNED NOT NULL DEFAULT 5,
	FOREIGN KEY (group_id) REFERENCES animal_group(id),
    FOREIGN KEY (type_id) REFERENCES animal_type(id)
);

#создаем низкоуравневые таблицы Camel:

DROP TABLE IF EXISTS camel;
CREATE TABLE camel (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    petname VARCHAR(50) COMMENT 'кличка',
    birthdate DATE,
    group_id INT UNSIGNED NOT NULL DEFAULT 2,
    type_id INT UNSIGNED NOT NULL DEFAULT 6,
	FOREIGN KEY (group_id) REFERENCES animal_group(id),
    FOREIGN KEY (type_id) REFERENCES animal_type(id)
);

#заполняем низкоуровневые таблицы:

INSERT INTO cat (petname, birthdate)
VALUES 	('Lisa', '2019-01-31'),
		('Kitty', '2022-01-31'),
		('Alena', '2021-05-16');

INSERT INTO dog (petname, birthdate)
VALUES 	('Sharik', '2018-01-16'),
		('Bobik', '2021-04-15'),
		('Alyasla', '2020-10-08');
	
INSERT INTO humster (petname, birthdate)
VALUES 	('Homa', '2022-01-30'),
		('Picksy', '2022-01-12'),
		('Gosha', '2021-10-13');
	
INSERT INTO horse (petname, birthdate)
VALUES 	('Dolly', '2020-02-20'),
		('Sindie', '2018-04-25'),
		('Klava', '2017-05-25');
	
INSERT INTO donkey (petname, birthdate)
VALUES 	('Ia', '2019-02-02'),
		('Sha', '2020-07-25'),
		('Kliff', '2021-04-17');
	
INSERT INTO camel (petname, birthdate)
VALUES 	('Vova', '2017-05-24'),
		('Pasha', '2018-04-23'),
		('Bloof', '2019-03-22');

#создаем таблицу домашних животных:

DROP TABLE IF EXISTS domestic_animal;
CREATE TABLE domestic_animal (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY)
SELECT  petname,
    	birthdate,
    	group_id,
    	type_id,
        'from_cat' AS from_previous
FROM cat UNION 
SELECT  petname,
    	birthdate,
    	group_id,
    	type_id,
        'from_dog' AS from_previous
FROM dog UNION
SELECT  petname,
    	birthdate,
    	group_id,
    	type_id,
        'from_humster' AS from_previous
FROM humster;

#создаем таблицу вьючных животных:

DROP TABLE IF EXISTS pack_animal;
CREATE TABLE pack_animal (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY)
SELECT  petname,
    	birthdate,
    	group_id,
    	type_id,
        'from_horse' AS from_previous
FROM horse UNION 
SELECT  petname,
    	birthdate,
    	group_id,
    	type_id,
        'from_donkey' AS from_previous
FROM donkey UNION
SELECT  petname,
    	birthdate,
    	group_id,
    	type_id,
        'from_camel' AS from_previous
FROM camel;

#удаляем верблюдов из таблицы:

DELETE FROM pack_animal WHERE type_id = (SELECT id FROM animal_type WHERE type_name = 'camel');

#создаем ОБЩУЮ таблицу животных:

DROP TABLE IF EXISTS animal;
CREATE TABLE animal (id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY)
SELECT  petname,
    	birthdate,
    	group_id,
    	type_id,
    	from_previous
FROM domestic_animal UNION
SELECT  petname,
    	birthdate,
    	group_id,
    	type_id,
    	from_previous
FROM pack_animal;

#создаем таблицу умения выполнять команды:

DROP TABLE IF EXISTS animal_skill;
CREATE TABLE animal_skill (
	animal_type INT UNSIGNED NOT NULL,
    skill_id INT UNSIGNED NOT NULL,
	FOREIGN KEY (animal_type) REFERENCES animal_type(id),
    FOREIGN KEY (skill_id) REFERENCES skill(id)
);

INSERT INTO animal_skill (animal_type, skill_id)
VALUES 	(1,2),
		(1,4),
		(1,5),
		(2,1),
		(2,4),
		(2,5),
		(3,3),
		(3,4),
		(3,5),
		(4,7),
		(4,8),
		(4,10),
		(5,4),
		(5,7),
		(5,10),
		(6,4),
		(6,7),
		(6,9),
		(6,10);
	
#создаем селект запрос на всех животных с их умениями:
	
SELECT a.id, petname, birthdate, type_name, group_name, skill, 
		(YEAR(CURRENT_DATE)-YEAR(birthdate)) - (RIGHT(CURRENT_DATE,5)<RIGHT(birthdate,5)) AS age
FROM animal AS a
LEFT JOIN animal_type AS at2
ON a.type_id = at2.id
LEFT JOIN animal_group AS ag
ON a.group_id = ag.id
LEFT JOIN animal_skill AS as2
ON a.type_id = as2.animal_type
LEFT JOIN skill as s
ON as2.skill_id = s.id;
	
#создаем таблицу молодые животные старше 1 года, но младше 3 лет (3 не входит), указываем возраст в годаах и месяцах:

DROP TABLE IF EXISTS young_animal;
CREATE TABLE young_animal (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY)
SELECT id, petname, birthdate,
	CONCAT_WS(' ', age_years, 'year(s)', age_months, 'month(s)') as age
FROM
(SELECT id, petname, birthdate, (YEAR(CURRENT_DATE)-YEAR(birthdate)) - (RIGHT(CURRENT_DATE,5)<RIGHT(birthdate,5)) AS age_years,
	CASE
		WHEN MONTH(NOW()) - MONTH(birthdate) - (RIGHT(CURRENT_DATE,2)<RIGHT(birthdate,2)) < 0
			THEN 12 + MONTH(NOW()) - MONTH(birthdate) - (RIGHT(CURRENT_DATE,2)<RIGHT(birthdate,2))
		ELSE MONTH(NOW()) - MONTH(birthdate) - (RIGHT(CURRENT_DATE,2)<RIGHT(birthdate,2))
	END as age_months
FROM animal
WHERE birthdate BETWEEN (NOW() - INTERVAL 3 YEAR) AND (NOW() - INTERVAL 1 YEAR)) sub;

SELECT * FROM young_animal
ORDER BY birthdate DESC;


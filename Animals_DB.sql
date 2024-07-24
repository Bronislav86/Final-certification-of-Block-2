-- БД HumanFriends для итогового задания

-- Создать таблицы, соответствующие иерархии из вашей диаграммы классов
CREATE TABLE Dogs (
ID INT AUTO_INCREMENT PRIMARY KEY,
Name VARCHAR(45) NOT NULL,
Type VARCHAR(45) NOT NULL,
BirthDate DATE NOT NULL,
Commands VARCHAR(125)
);

CREATE TABLE Cats (
ID INT AUTO_INCREMENT PRIMARY KEY,
Name VARCHAR(45) NOT NULL,
Type VARCHAR(45) NOT NULL,
BirthDate DATE NOT NULL,
Commands VARCHAR(125)
);

CREATE TABLE Humsters (
ID INT AUTO_INCREMENT PRIMARY KEY,
Name VARCHAR(45) NOT NULL,
Type VARCHAR(45) NOT NULL,
BirthDate DATE NOT NULL,
Commands VARCHAR(125)
);

INSERT INTO Cats (Name, Type, BirthDate, Commands)
VALUES
('Whiskers', 'Cat', '2019-05-15', 'Sit, Pounce');

INSERT INTO Dogs (Name, Type, BirthDate, Commands)
VALUES
('Fido', 'Dog', '2020-01-01', 'Sit, Stay, Fetch'),
('Buddy', 'Dog', '2018-12-10', 'Sit, Paw, Bark');

INSERT INTO Humsters (Name, Type, BirthDate, Commands)
VALUES
('Hummy', 'Humster', '2021-03-10', 'Roll, Hide');

CREATE TABLE Horses (
ID INT AUTO_INCREMENT PRIMARY KEY,
Name VARCHAR(45) NOT NULL,
Type VARCHAR(45) NOT NULL,
BirthDate DATE NOT NULL,
Commands VARCHAR(125)
);

CREATE TABLE Camels (
ID INT AUTO_INCREMENT PRIMARY KEY,
Name VARCHAR(45) NOT NULL,
Type VARCHAR(45) NOT NULL,
BirthDate DATE NOT NULL,
Commands VARCHAR(125)
);

CREATE TABLE Donkeys (
ID INT AUTO_INCREMENT PRIMARY KEY,
Name VARCHAR(45) NOT NULL,
Type VARCHAR(45) NOT NULL,
BirthDate DATE NOT NULL,
Commands VARCHAR(125)
);

INSERT INTO Horses (Name, Type, BirthDate, Commands)
VALUES
('Thunder', 'Horse', '2015-07-21', 'Trot, Canter, Gallop'),
('Storm', 'Horse', '2014-05-05', 'Trot, Canter'),
('Blaze', 'Horse', '2016-02-29', 'Trot, Jump, Gallop');

INSERT INTO Camels (Name, Type, BirthDate, Commands)
VALUES
('Sandy', 'Camel', '2016-11-03', 'Walk, Carry Load'),
('Dune', 'Camel', '2018-12-12', 'Walk, Sit'),
('Sahara', 'Camel', '2015-08-14', 'Walk, Run');

INSERT INTO Donkeys (Name, Type, BirthDate, Commands)
VALUES
('Eeyore', 'Donkey', '2017-09-08', 'Walk, Carry Load, Bray'),
('Burro', 'Donkey', '2019-01-23', 'Walk, Bray, Kick');

-- Заполнить таблицы данными о животных, их командах и датами рождения

DROP TABLE IF EXISTS Pets;
CREATE TABLE Pets (
ID INT AUTO_INCREMENT PRIMARY KEY,
Name VARCHAR(45) NOT NULL,
Type VARCHAR(45) NOT NULL,
BirthDate DATE NOT NULL,
Commands VARCHAR(125)
);

INSERT INTO Pets (Name, Type, BirthDate, Commands)
SELECT Name, Type, BirthDate, Commands FROM Dogs
UNION ALL
SELECT Name, Type, BirthDate, Commands FROM Cats
UNION ALL
SELECT Name, Type, BirthDate, Commands FROM Humsters;

DROP TABLE IF EXISTS PackAnimaks;
CREATE TABLE PackAnimaks (
ID INT AUTO_INCREMENT PRIMARY KEY,
Name VARCHAR(45) NOT NULL,
Type VARCHAR(45) NOT NULL,
BirthDate DATE NOT NULL,
Commands VARCHAR(125)
);

INSERT INTO PackAnimaks (Name, Type, BirthDate, Commands)
SELECT Name, Type, BirthDate, Commands FROM Horses
UNION ALL
SELECT Name, Type, BirthDate, Commands FROM Camels
UNION ALL
SELECT Name, Type, BirthDate, Commands FROM Donkeys;

-- 	Удалить записи о верблюдах и объединить таблицы лошадей и ослов.

DELETE FROM PackAnimaks
WHERE Type = 'Camel';

DROP TABLE IF EXISTS animals;
CREATE TEMPORARY TABLE animals AS
SELECT * FROM horses
UNION SELECT * FROM donkeys
UNION SELECT * FROM camels;

SELECT * FROM animals;

-- Создать новую таблицу для животных в возрасте от 1 до 3 лет и вычислить их возраст с точностью до месяца.

DROP TABLE IF EXISTS age_in_months;
CREATE TABLE age_in_months AS
SELECT Name, Type, Commands, TIMESTAMPDIFF(MONTH, BirthDate, CURDATE()) AS age_in_months
FROM Animals;

SELECT * FROM animals;

DROP TABLE IF EXISTS young_animals;
CREATE TABLE young_animals
SELECT Name, Type, Commands, age_in_months
FROM age_in_months
WHERE age_in_months BETWEEN 12 AND 36;

-- Объединить все созданные таблицы в одну, сохраняя информацию о принадлежности к исходным таблицам.

SELECT d.name, d.type, d.birthdate, a.age_in_months, d.commands
FROM dogs d LEFT JOIN age_in_months a ON d.name = a.name
UNION
SELECT c.name, c.type, c.birthdate, a.age_in_months, c.commands
FROM cats c LEFT JOIN age_in_months a ON c.name = a.name
UNION
SELECT h.name, h.type, h.birthdate, a.age_in_months, h.commands
FROM humsters h LEFT JOIN age_in_months a ON h.name = a.name
UNION
SELECT hr.name, hr.type, hr.birthdate, a.age_in_months, hr.commands
FROM horses hr LEFT JOIN age_in_months a ON hr.name = a.name
UNION
SELECT dn.name, dn.type, dn.birthdate, a.age_in_months, dn.commands
FROM donkeys dn LEFT JOIN age_in_months a ON dn.name = a.name;
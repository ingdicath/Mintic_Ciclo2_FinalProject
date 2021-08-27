DROP SCHEMA IF EXISTS veterinariaPoopis;
CREATE SCHEMA veterinariaPoopis;
USE veterinariaPoopis;

CREATE TABLE IF NOT EXISTS propietario(
	propId INT auto_increment PRIMARY KEY,
	propUsuario VARCHAR(30) NOT NULL,
	propApellido VARCHAR(30) NOT NULL,
	propNombre VARCHAR (30) NOT NULL,
	propTelefono CHAR(25) NULL
 );
 
INSERT INTO propietario(propId, propUsuario, propApellido, propNombre, propTelefono) VALUES (1, 'vincent', 'Vanghogh', 'Vicente', '3221234564');
INSERT INTO propietario(propId, propUsuario, propApellido, propNombre, propTelefono) VALUES (2, 'dantonito', 'Antony', 'Diego', '3133151232');
INSERT INTO propietario(propId, propUsuario, propApellido, propNombre, propTelefono) VALUES (3, 'haylee', 'Lee', 'Hayo', '3192212121');
INSERT INTO propietario(propId, propUsuario, propApellido, propNombre, propTelefono) VALUES (4, 'cristop', 'Rojas', 'Christopher', '2927272 ext 333');
INSERT INTO propietario(propId, propUsuario, propApellido, propNombre, propTelefono) VALUES (5, 'JReina', 'Reina', 'Johan', '+549 4984445413');
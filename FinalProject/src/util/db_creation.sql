DROP SCHEMA IF EXISTS PetStoreDiDi;
CREATE SCHEMA PetStoreDiDi;
USE PetStoreDiDi;

CREATE TABLE propietario(
	propId INT auto_increment PRIMARY KEY,
	propUsuario VARCHAR(30) NOT NULL,
	propApellido VARCHAR(30) NOT NULL,
	propNombre VARCHAR (30) NOT NULL,
	propTelefono CHAR(25) NULL
 );
 
CREATE TABLE mascota(
	mascotaId INT auto_increment PRIMARY KEY,
    mascotaNombre CHAR(30) NOT NULL,
    propId INT NOT NULL,
    FOREIGN KEY(propId) REFERENCES propietario(propId)
);

CREATE TABLE cita(
	citaId INT auto_increment PRIMARY KEY,
    citaFecha DATE NOT NULL,
    citaDescripcion VARCHAR(180) NOT NULL,
    mascotaId INT NOT NULL,
    FOREIGN KEY (mascotaId) REFERENCES mascota(mascotaId)
);

INSERT INTO propietario(propUsuario, propApellido, propNombre, propTelefono) VALUES ('vincent', 'Vanghogh', 'Vicente', '3221234564');
INSERT INTO propietario(propUsuario, propApellido, propNombre, propTelefono) VALUES ('dantonito', 'Antony', 'Diego', '3133151232');
INSERT INTO propietario(propUsuario, propApellido, propNombre, propTelefono) VALUES ('haylee', 'Lee', 'Hayo', '3192212121');
INSERT INTO propietario(propUsuario, propApellido, propNombre, propTelefono) VALUES ('cristop', 'Rojas', 'Christopher', '2927272 ext 333');
INSERT INTO propietario(propUsuario, propApellido, propNombre, propTelefono) VALUES ('JReina', 'Reina', 'Johan', '+549 4984445413');

INSERT INTO mascota(mascotaNombre, propId) VALUES ('Sam', 5);
INSERT INTO mascota(mascotaNombre, propId) VALUES ('Merlín', 4);
INSERT INTO mascota(mascotaNombre, propId) VALUES ('Toby', 5);
INSERT INTO mascota(mascotaNombre, propId) VALUES ('Kira', 2);
INSERT INTO mascota(mascotaNombre, propId) VALUES ('Sasha', 1);
INSERT INTO mascota(mascotaNombre, propId) VALUES ('Tribilín', 2);

INSERT INTO cita(citaFecha, citaDescripcion, mascotaId) VALUES ('2021-08-01 15:30:00', 'El gato se encuentra con un peso normal y en su cita de control de ojos al parecer la catarata se detuvo', 1);
INSERT INTO cita(citaFecha, citaDescripcion, mascotaId) VALUES ('2021-08-02 18:30:00', 'Merlín presenta halitosis reflejo de un problema localizado en la boca o incluso de algún problema del aparato digestivo.', 2);
INSERT INTO cita(citaFecha, citaDescripcion, mascotaId) VALUES ('2021-06-30 04:30:20', 'El pronóstico es reservado. Presenta molestias bucales (gingivitis), vómitos, fiebre. Se deja en hospitalización.', 4);
INSERT INTO cita(citaFecha, citaDescripcion, mascotaId) VALUES ('2021-08-13 16:30:20', 'Viene para el programa de perritos de la tercera edad', 5);
INSERT INTO cita(citaFecha, citaDescripcion, mascotaId) VALUES ('2021-08-14 15:07:20', 'Viene por esquema de vacunacion', 5);
INSERT INTO cita(citaFecha, citaDescripcion, mascotaId) VALUES ('2021-08-27 08:35:20', 'Viene por esquema de vacunacion', 1);
INSERT INTO cita(citaFecha, citaDescripcion, mascotaId) VALUES ('2021-07-02 04:30:20', 'Pronostico mejora. Se remite a cuidados intermedios', 4);
INSERT INTO cita(citaFecha, citaDescripcion, mascotaId) VALUES ('2021-07-05 09:15:35', 'Se le realizan examenes complementarios a Kira. Aun sigue en cuidados intermedios', 4);
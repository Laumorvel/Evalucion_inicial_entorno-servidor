ALTER SESSION set  NLS_DATE_FORMAT = 'DD-MM-YYYY HH24:MI';

DROP TABLE clinicas_veterinarios;
DROP TABLE veterinarios;
DROP TABLE mascotas;
DROP TABLE personas;
DROP TABLE clinicas; 

-- CREACIÓN DE TABLAS --
-- !! Usando Live SQL a veces me ha dado errores por tener comentarios al lado aunque no debería (ojo)
-- prefiero no usar ON DELETE CASCADE por seguridad
--las personas que forman parte de esta BBDD están registradas como clientes de una y solo una clínica veterinaria (lo normal es no ir a +1 clínica veterinaria)
CREATE TABLE clinicas(
    codigo_clinic number(3) constraint pk_clinicas primary key,
    nombre	varchar2(60),
    direccion varchar2(50),
	fecha_apertura date
);

CREATE TABLE personas(
	codigo_pers	number(2) constraint pk_personas primary key,
    cod_clinica number(2) constraint fk_clinica references clinicas NOT NULL,
	dni	varchar2(9) not null,
	nombre	varchar2(30),
	apellidos varchar2(50),
	direccion varchar2(50),
	fecha_nacimiento date
);

CREATE TABLE mascotas(
    codigo_mas	number(2) constraint pk_mascotas primary key,
    codigo_duenyo number(2) constraint fk_duenyo references personas, --una persona puede tener +1 mascota y la mascota siempre un dueño. No es necesario crea otra tabla.
                                                                      --(aparecería aquí repetido su código en tantas columnas como mascotas tenga).
    nombre	varchar2(30) not null,
	fecha_nacimiento date,
    especie varchar2(50) not null
);


CREATE TABLE veterinarios(
    codigo_vet	number(2) constraint pk_veterinarios primary key,
    codigo_pers	number(2) constraint fk_personas references personas, --para obtener su info personal
    anyo_experiencia number(2)
);

CREATE TABLE clinicas_veterinarios(
    codigo_vete number(2) constraint fk_veterinarios references veterinarios, --relación N a M (los veterinarios pueden trabajar en varias clínicas y viceversa)
    codigo_clinica number(3) constraint fk_clinicas references clinicas,
    PRIMARY KEY (codigo_vete, codigo_clinica)
);



-- INSERCIÓN DE DATOS -- 
--Como voy a insertar datos en todos los campos de la tabla, por eso lo hago de esta manera (sin nombrar los campos)

INSERT INTO CLINICAS VALUES (11, 'Clínica veterinaria El perro feliz', 'Calle ancha, 23', '20/05/2000');
INSERT INTO CLINICAS VALUES (12, 'Best clínica veterinaria ever', 'Calle estrecha, 2', '23/07/1999');
INSERT INTO CLINICAS VALUES (13, 'Clínica veterinaria Quintero', 'Calle mediana, 11', '21/06/1998');

INSERT INTO personas VALUES (1, 11, '30302626J', 'Loli', 'Montes Castro', 'Avenida América, 4', '19/02/2007');
INSERT INTO personas VALUES (2, 12, '23000123C', 'Jorge', 'Garcia Garcia', 'Saravia 1', '19/03/1999');
INSERT INTO personas VALUES (3, 13, '14000123F', 'Gonzalo', 'Castillo Moreno', 'Avenida Florida, 4', '10/03/2001');
INSERT INTO personas VALUES (4, 11, '29000123T', 'Maria', 'Jimenez Jimenez', 'La Paz 23', '29/03/2000');
INSERT INTO personas VALUES (5, 12, '1200012W', 'Rafael', 'Latorre Latorre', 'La Paz 13', '20/11/1995');
INSERT INTO personas VALUES (6, 13, '12000123X', 'Juana', 'Castillo Jimenez', 'Saravia, 13', '08/09/2005');
INSERT INTO personas VALUES (7, 11, '31000123P', 'Juan', 'Montero Montero', 'Joselito Palotes, 2', '17/06/1998');
INSERT INTO personas VALUES (8, 12, '75432890P', 'Gustavo', 'Montes Marino', 'Avenida Ecuador, 7', '22/02/1997');
INSERT INTO personas VALUES (9, 13, '22222222T', 'Hector', 'Casablanca Castro', 'Avenida Argentina, 8', '19/08/2006');
INSERT INTO personas VALUES (10, 12, '33333333U', 'Sara', 'Garcia Moreno', 'Avenida Alemania, 14', '19/11/2003');


INSERT INTO MASCOTAS VALUES (1, 1, 'Boby', '19/11/2010','perro');
INSERT INTO MASCOTAS VALUES (2, 2, 'Lili', '19/12/2011','gato');
INSERT INTO MASCOTAS VALUES (3, 3, 'Canelita', '08/02/2015','conejo');
INSERT INTO MASCOTAS VALUES (4, 4, 'Ali', '03/03/2010','mono');
INSERT INTO MASCOTAS VALUES (5, 5, 'Pepita', '04/02/2019','cerdo vietnamita');
INSERT INTO MASCOTAS VALUES (6, 6, 'Bigotitos', '06/02/2010','gato');
INSERT INTO MASCOTAS VALUES (7, 7, 'Oreo', '10/09/2009','perro');
INSERT INTO MASCOTAS VALUES (8, 8, 'Ragnar', '08/08/2020','conejo');
INSERT INTO MASCOTAS VALUES (9, 9, 'Walter', '18/05/2021','hamster');
INSERT INTO MASCOTAS VALUES (10, 10, 'Sol', '19/06/2013','canario');
INSERT INTO MASCOTAS VALUES (11, 1, 'Luna', '01/08/2012','gato');
INSERT INTO MASCOTAS VALUES (12, 2, 'Manchas', '02/07/2011','perro');
INSERT INTO MASCOTAS VALUES (13, 3, 'Burbujas', '18/03/2014','pez');
INSERT INTO MASCOTAS VALUES (14, 4, 'Happy', '12/05/2015','hamster');


INSERT INTO veterinarios VALUES (11, 1, 2);
INSERT INTO veterinarios VALUES (22, 3, 20);
INSERT INTO veterinarios VALUES (33, 4, 12);
INSERT INTO veterinarios VALUES (44, 5, 5);
INSERT INTO veterinarios VALUES (55, 6, 8);
INSERT INTO veterinarios VALUES (66, 7, 9);


INSERT INTO clinicas_veterinarios VALUES (11, 11);
INSERT INTO clinicas_veterinarios VALUES (11, 12);
INSERT INTO clinicas_veterinarios VALUES (22, 11);
INSERT INTO clinicas_veterinarios VALUES (22, 13);
INSERT INTO clinicas_veterinarios VALUES (33, 11);
INSERT INTO clinicas_veterinarios VALUES (44, 13);
INSERT INTO clinicas_veterinarios VALUES (55, 13);
INSERT INTO clinicas_veterinarios VALUES (55, 11);
INSERT INTO clinicas_veterinarios VALUES (66, 13);
INSERT INTO clinicas_veterinarios VALUES (66, 11);
INSERT INTO clinicas_veterinarios VALUES (22, 12);


-- MODIFICACIÓN DE DATOS (DML) -- 

--INSERTAR
INSERT INTO PERSONAS VALUES (11, 12, '33355553U', 'Jose', 'Montero Moreno', 'Avenida Filipinas, 54', '02/12/2013');
INSERT INTO veterinarios VALUES (77, 11, 2);
INSERT INTO clinicas_veterinarios VALUES (77, 13);

--MODIFICAR
UPDATE PERSONAS SET direccion = 'Avenida America, 6' WHERE codigo_pers = 1; 
UPDATE clinicas SET direccion = 'Avenida Londres, 16' WHERE codigo_clinic = 13; 
UPDATE veterinarios SET anyo_experiencia = 18 WHERE codigo_vet = 11; 

--ELIMINAR
DELETE FROM PERSONAS WHERE codigo_pers = 10; 

--CONSULTAS 
SELECT * FROM VETERINARIOS;

SELECT MAX(anyo_experiencia) FROM veterinarios;

SELECT nombre FROM personas WHERE fecha_nacimiento > '01/01/2005';

SELECT COUNT(especie) FROM mascotas WHERE especie = 'perro';

--nombre de veterinarios que trabajan en la clinica de codigo 13 (no todas las personas son veterinarios)
SELECT DISTINCT p.nombre AS nombre_veterinarios FROM personas p, veterinarios v WHERE p.codigo_pers = v.codigo_pers AND p.cod_clinica = 13;

-- JOIN - número de veterinarios por clínica
SELECT COUNT(cv.codigo_vete) AS NÚMERO_VETERINARIOS, c.nombre  AS CLÍNICAS FROM clinicas_veterinarios cv, clinicas c 
WHERE c.codigo_clinic = cv.codigo_clinica GROUP BY c.nombre;

-- SUBCONSULTA - personas que no son veterinarios
SELECT p.nombre AS nombre_no_veterinarios FROM personas p WHERE p.codigo_pers 
NOT IN (SELECT v.codigo_pers FROM veterinarios v);


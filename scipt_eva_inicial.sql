ALTER SESSION set  NLS_DATE_FORMAT = 'DD-MM-YYYY HH24:MI';

DROP TABLE clinicas_veterinarios;
DROP TABLE veterinarios;
DROP TABLE clinicas; 
DROP TABLE mascotas;
DROP TABLE personas;

-- CREACIÓN DE TABLAS --
-- prefiero no usar ON DELETE CASCADE 

CREATE TABLE personas(
	codigo_pers	number(2) constraint pk_personas primary key,
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

CREATE TABLE clinicas(
    codigo_clinic number(3) constraint pk_clinicas primary key,
    cod_clientes number(2) constraint fk_clientes references personas,
    nombre	varchar2(60),
    direccion varchar2(50),
	fecha_apertura date
);

CREATE TABLE veterinarios(
    codigo_vet	number(2) constraint pk_veterinarios primary key,
    codigo_pers	number(2) constraint fk_personas references personas, --para obtener su info personal
    anyo_experiencia number(2)
);

CREATE TABLE clinicas_veterinarios(
    codigo_vete number(2) constraint fk_veterinarios references veterinarios, --relación N a M
    codigo_clinica number(3) constraint fk_clinicas references clinicas,
    PRIMARY KEY (codigo_vete, codigo_clinica)
);

-- INSERCIÓN DE DATOS -- 
INSERT INTO personas VALUES (1, '30302626J', 'Loli', 'Montes Castro', 'Avenida América, 4', '19/02/2007');
INSERT INTO personas VALUES (2, '23000123C', 'Jorge', 'Garcia Garcia', 'Saravia 1', '19/03/1999');
INSERT INTO personas VALUES (3, '14000123F', 'Gonzalo', 'Castillo Moreno', 'Avenida Florida, 4', '10/03/2001');
INSERT INTO personas VALUES (4, '29000123T', 'Maria', 'Jimenez Jimenez', 'La Paz 23', '29/03/2000');
INSERT INTO personas VALUES (5, '1200012W', 'Rafael', 'Latorre Latorre', 'La Paz 13', '20/11/1995');
INSERT INTO personas VALUES (6, '12000123X', 'Juana', 'Castillo Jimenez', 'Saravia, 13', '08/09/2005');
INSERT INTO personas VALUES (7, '31000123P', 'Juan', 'Montero Montero', 'Joselito Palotes, 2', '17/06/1998');
INSERT INTO personas VALUES (8, '75432890P', 'Gustavo', 'Montes Marino', 'Avenida Ecuador, 7', '22/02/1997');
INSERT INTO personas VALUES (9, '22222222T', 'Hector', 'Casablanca Castro', 'Avenida Argentina, 8', '19/08/2006');
INSERT INTO personas VALUES (10, '33333333U', 'Sara', 'Garcia Moreno', 'Avenida Alemania, 14', '19/11/2003');


CREATE DATABASE IF NOT EXISTS Concesionario;
USE Concesionario;

DROP TABLE IF EXISTS VEHICULO;
CREATE TABLE VEHICULO (
 id INTEGER AUTO_INCREMENT PRIMARY KEY,
 tipo TEXT NOT NULL,
 marca TEXT NOT NULL,
 modelo TEXT NOT NULL,
 precio REAL NOT NULL,
 num_puertas INTEGER,
 tipo_combustible TEXT,
 cilindrada INTEGER,
 tiene_sidecar BOOLEAN,
 tipo_bicicleta TEXT,
 tiene_cambio BOOLEAN
);

INSERT INTO VEHICULO (tipo, marca, modelo, precio, num_puertas, tipo_combustible)
VALUES ('Coche', 'Toyota', 'Corolla', 18000, 4, 'Gasolina');

INSERT INTO VEHICULO (tipo, marca, modelo, precio, cilindrada, tiene_sidecar)
VALUES ('Moto', 'Honda', 'CB500', 6500, 500, 0);

INSERT INTO VEHICULO (tipo, marca, modelo, precio, tipo_bicicleta, tiene_cambio)
VALUES ('Bicicleta', 'Specialized', 'Allez', 1200, 'Carretera', 1);
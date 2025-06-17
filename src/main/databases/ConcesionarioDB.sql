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

-- Coches
INSERT INTO VEHICULO (tipo, marca, modelo, precio, num_puertas, tipo_combustible) VALUES
  ('Coche', 'Toyota',         'Corolla',    18000, 4, 'Gasolina'),
  ('Coche', 'Ford',           'Fiesta',     15000, 5, 'Diésel'),
  ('Coche', 'Tesla',          'Model 3',    35000, 4, 'Eléctrico'),
  ('Coche', 'Volkswagen',     'Golf',       22000, 5, 'Gasolina'),
  ('Coche', 'BMW',            'Serie 3',    35000, 4, 'Diésel'),
  ('Coche', 'Audi',           'A4',         34000, 4, 'Gasolina'),
  ('Coche', 'Chevrolet',      'Cruze',      20000, 4, 'Diésel'),
  ('Coche', 'Nissan',         'Altima',     23000, 4, 'Gasolina'),
  ('Coche', 'Hyundai',        'Elantra',    18000, 4, 'Gasolina'),
  ('Coche', 'Kia',            'Rio',        16000, 4, 'Gasolina'),
  ('Coche', 'Mercedes-Benz',  'C200',       40000, 4, 'Híbrido'),
  ('Coche', 'Renault',        'Clio',       15000, 5, 'Gasolina'),
  ('Coche', 'Peugeot',        '208',        14000, 5, 'Eléctrico');

-- Motos
INSERT INTO VEHICULO (tipo, marca, modelo, precio, cilindrada, tiene_sidecar) VALUES
  ('Moto', 'Honda',            'CB500',       6500,  500, 0),
  ('Moto', 'Yamaha',           'MT-07',       7000,  689, 0),
  ('Moto', 'Ducati',           'Monster',    12000,  821, 0),
  ('Moto', 'BMW',              'R1200',      14000, 1200, 0),
  ('Moto', 'Kawasaki',         'Ninja ZX-6R',11500,  636, 0),
  ('Moto', 'Suzuki',           'GSX-R600',   11200,  599, 0),
  ('Moto', 'KTM',              'Duke 390',    5000,  373, 0),
  ('Moto', 'Harley-Davidson',  'Street 750',  8000,  749, 0),
  ('Moto', 'Triumph',          'Bonneville', 10500,  900, 0),
  ('Moto', 'Aprilia',          'RSV4',       16000, 1078, 0),
  ('Moto', 'Ural',             'Gear Up',    14500,  750, 1),
  ('Moto', 'Moto Guzzi',       'V7',          9000,  744, 0);

-- Bicicletas
INSERT INTO VEHICULO (tipo, marca, modelo, precio, tipo_bicicleta, tiene_cambio) VALUES
  ('Bicicleta', 'Specialized', 'Allez',      1200, 'Carretera', 1),
  ('Bicicleta', 'Trek',        'Marlin 7',    900, 'Montaña',   1),
  ('Bicicleta', 'Brompton',    'M3L',        1500, 'Plegable',  0),
  ('Bicicleta', 'Giant',       'Defy',       1300, 'Carretera', 1),
  ('Bicicleta', 'Cannondale',  'Synapse',    1500, 'Carretera', 1),
  ('Bicicleta', 'Scott',       'Speedster',  1200, 'Carretera', 1),
  ('Bicicleta', 'Canyon',      'Ultimate',   2000, 'Carretera', 1),
  ('Bicicleta', 'Orbea',       'Orca',       2300, 'Carretera', 1),
  ('Bicicleta', 'Merida',      'Scultura',   1800, 'Carretera', 1),
  ('Bicicleta', 'Pinarello',   'Prince',     3000, 'Carretera', 1),
  ('Bicicleta', 'Colnago',     'C64',        4500, 'Carretera', 1),
  ('Bicicleta', 'Cervelo',     'R5',         3500, 'Carretera', 1),
  ('Bicicleta', 'Bianchi',     'Impulso',    1400, 'Urbana',    1);

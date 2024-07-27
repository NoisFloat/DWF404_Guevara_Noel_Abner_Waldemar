-- Creación de la base de datos
CREATE DATABASE GameHubDWF;

-- Selección de la base de datos
USE GameHubDWF;

-- Creación de la tabla videojuego
CREATE TABLE videojuego (
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            nombre VARCHAR(255) NOT NULL,
                            genero VARCHAR(100) NOT NULL,
                            precio DECIMAL(10,2) NOT NULL
);

-- Creación de la tabla venta
CREATE TABLE venta (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       videojuego_id INT NOT NULL,
                       fecha DATE NOT NULL,
                       cantidad INT NOT NULL,
                       FOREIGN KEY (videojuego_id) REFERENCES videojuego(id)
);

-- Inserción de datos de prueba en la tabla videojuego
INSERT INTO videojuego (nombre, genero, precio) VALUES
                                                    ('The Legend of Zelda: Breath of the Wild', 'Aventura', 59.99),
                                                    ('Super Mario Odyssey', 'Plataformas', 49.99),
                                                    ('Animal Crossing: New Horizons', 'Simulación', 39.99);

-- Inserción de datos de prueba en la tabla venta
INSERT INTO venta (videojuego_id, fecha, cantidad) VALUES
                                                       (1, '2024-07-01', 100),
                                                       (2, '2024-07-02', 150),
                                                       (3, '2024-07-03', 200);

# API de Hoteles y Reservas

## Descripción
Esta API permite gestionar hoteles y reservas utilizando **Spring Boot** y **MySQL**.

## Endpoints

### Hoteles
- **GET /hoteles/** → Lista todos los hoteles
- **GET /hoteles/{id}** → Ver detalles de un hotel
- **GET /hoteles/estrellas/{estrellas}** → Lista los hoteles que tienen esa cantidad de estrellas
- **POST /hoteles/** → Crear un hotel
- **PUT /hoteles/{id}** → Modificar un hotel
- **DELETE /hoteles/{id}** → Eliminar un hotel

### Reservas
- **GET /reservas/** → Lista todas las reservas
- **GET /reservas/{id}** → Ver detalles de una reserva
- **POST /reservas/** → Crear una nueva reserva
- **PUT /reservas/{id}** → Modificar una reserva existente
- **DELETE /reservas/{id}** → Eliminar una reserva

## Cómo ejecutar la API

### Opción 1: Ejecutar con Maven
1. Instala **MySQL** y crea la base de datos:
   ```sql
   CREATE DATABASE hoteles_db;
   USE hoteles_db;
   ```

2. Crea las tablas necesarias:
   ```sql
   CREATE TABLE hotel (
       id INT AUTO_INCREMENT PRIMARY KEY,
       nombre VARCHAR(255) NOT NULL,
       direccion VARCHAR(255) NOT NULL,
       estrellas INT NOT NULL
   );

   CREATE TABLE reserva (
       id INT AUTO_INCREMENT PRIMARY KEY,
       cliente VARCHAR(255) NOT NULL,
       fechaEntrada DATE NOT NULL,
       fechaSalida DATE NOT NULL,
       hotel_id INT,
       FOREIGN KEY (hotel_id) REFERENCES hotel(id) ON DELETE CASCADE
   );
   ```

3. Inserta algunos valores de ejemplo:
   ```sql
   INSERT INTO hotel (nombre, direccion, estrellas) 
   VALUES 
   ('Hotel Sol', 'Avenida del Mar 45', 4),
   ('Hotel Luna', 'Calle de la Estrella 99', 5),
   ('Hotel Brisa', 'Paseo Marítimo 12', 3),
   ('Hotel Montaña', 'Carretera Sierra 8', 4),
   ('Hotel Oasis', 'Boulevard Central 23', 5),
   ('Hotel Costa', 'Plaza del Puerto 7', 3),
   ('Hotel Ciudad', 'Calle Mayor 56', 4),
   ('Hotel Elegance', 'Avenida de la Moda 32', 5),
   ('Hotel Confort', 'Ronda Sur 15', 3),
   ('Hotel Panorama', 'Camino de la Vista 20', 4);
   ```

4. Inserta algunas reservas de prueba:
   ```sql
   INSERT INTO reserva (cliente, fechaEntrada, fechaSalida, hotel_id)
   VALUES 
   ('Juan Pérez', '2025-03-01', '2025-03-05', 1),
   ('María López', '2025-04-10', '2025-04-15', 2),
   ('Carlos Sánchez', '2025-05-20', '2025-05-25', 3),
   ('Ana Fernández', '2025-06-05', '2025-06-10', 4),
   ('Pedro Gómez', '2025-07-12', '2025-07-17', 5),
   ('Laura Méndez', '2025-08-20', '2025-08-25', 6),
   ('Daniel Ríos', '2025-09-15', '2025-09-20', 7),
   ('Sofía Herrera', '2025-10-10', '2025-10-15', 8),
   ('Hugo Martínez', '2025-11-01', '2025-11-06', 9),
   ('Valeria Ortega', '2025-12-05', '2025-12-10', 10);
   ```

Ahora puedes acceder a la API desde el navegador o Postman:
```
http://localhost:8080/hoteles
```

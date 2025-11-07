# 🧩 Backend - Nexus

Backend desarrollado con **Spring Boot** y **MySQL** para gestionar la lógica del proyecto **Nexus**, una aplicación web que ofrece servicios empresariales, manejo de usuarios y recepción de mensajes de contacto.

---

## 🚀 Tecnologías utilizadas

- **Java 17+**  
- **Spring Boot 3+**  
  - Spring Web  
  - Spring Data JPA  
  - Spring Boot DevTools  
- **MySQL** (Base de datos relacional)  
- **Lombok** (para reducir código repetitivo en las entidades)  
- **Maven** (gestor de dependencias)
- **Cloudinary** (almacenamiento imagenes)

---

## ⚙️ Configuración de la base de datos

Edita el archivo `src/main/resources/application.properties` con tus credenciales locales y la sesion de Cloudinary con las credenciales respectivas:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/nexus_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=tu_contraseña

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

server.port=8080

// Cloudinary configuration
cloudinary.cloud_name=${CLOUDINARY_CLOUD_NAME}
cloudinary.api_key=${CLOUDINARY_API_KEY}
cloudinary.api_secret=${CLOUDINARY_API_SECRET}
```

## 📈 Código de base de datos
```
CREATE DATABASE IF NOT EXISTS webapp_db;
USE webapp_db;

-- ==========================
-- Tabla de Usuarios
-- ==========================
CREATE TABLE usuarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  correo VARCHAR(150) NOT NULL UNIQUE,
  contrasena VARCHAR(255) NOT NULL,
  rol ENUM('usuario', 'admin') DEFAULT 'usuario'
);

select * from usuarios;

INSERT INTO usuarios (correo, contrasena, rol) VALUES
('admin@correo.com', 'admin123', 'admin'),
('usuario1@correo.com', 'userpass1', 'usuario'),
('usuario2@correo.com', 'userpass2', 'usuario');

-- ==========================
-- Tabla de Servicios (Cards)
-- ==========================
CREATE TABLE servicios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  titulo VARCHAR(100) NOT NULL,
  description TEXT NOT NULL,
  imagen_url VARCHAR(255),
  creado TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  actualizado TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

select * from servicios;

INSERT INTO servicios (titulo, description, imagen_url) VALUES
('Automatización Empresarial', 'Implementación de sistemas automatizados para mejorar la eficiencia operativa.', 'https://res.cloudinary.com/dduvfwgaf/image/upload/v1762531906/empresarial_uy0avc.jpg'),
('Desarrollo Web', 'Diseño y desarrollo de aplicaciones web modernas y escalables.', 'https://res.cloudinary.com/dduvfwgaf/image/upload/v1762531445/desarrolloWeb_bojftm.jpg'),
('Integración de APIs', 'Conectamos tu negocio con servicios externos mediante integraciones seguras.', 'https://res.cloudinary.com/dduvfwgaf/image/upload/v1762531443/integracionApi_oooh2m.jpg');

-- ==========================
-- Tabla de Estadisticas (Logros)
-- ==========================
CREATE TABLE estadisticas (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre_metrica VARCHAR(50) NOT NULL,
  valor_metrica VARCHAR(20) NOT NULL,
  icono_url VARCHAR(255),
  last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

select * from estadisticas;

INSERT INTO estadisticas (nombre_metrica, valor_metrica, icono_url) VALUES
('Clientes', '120+', 'https://drive.google.com/file/d/1A_41_mfuR3Idq9HbgJFqHGLuigffRZtE/view?usp=drive_link'),
('Proyectos', '45', 'https://drive.google.com/file/d/1rbftphSgkF251blhvDmlSLDEyRGHjnRn/view?usp=drive_link'),
('Premios', '8', 'https://drive.google.com/file/d/1wvgaMM1ACqvqIiCxSwbCz-uKTVzk_Vr_/view?usp=drive_link');

-- ==========================
-- Tabla de Contactos
-- ==========================
CREATE TABLE contactos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  correo VARCHAR(150) NOT NULL,
  mensaje TEXT NOT NULL,
  fecha_envio TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

select * from contactos;

INSERT INTO contactos (nombre, correo, mensaje) VALUES
('Carlos Gómez', 'carlos@example.com', 'Estoy interesado en implementar un sistema para mi empresa.'),
('Lucía Torres', 'lucia@example.com', 'Me gustaría conocer más sobre sus planes de automatización.'),
('Pedro Ramírez', 'pedro@example.com', '¿Pueden integrarse con plataformas externas como Shopify?');

```

💡 Asegúrate de que MySQL esté ejecutándose y que la base de datos nexus_db exista.

## 🧰 Ejecución del proyecto

### 1. Clona el repositorio:
```Clona el repositorio:```
### 2. Abre el proyecto en VS Code o IntelliJ IDEA.
### 3. Ejecuta el proyecto.
```mvn spring-boot:run```
### 4. Verifica el backend en: 👉 http://localhost:8080



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

---

## ⚙️ Configuración de la base de datos

Edita el archivo `src/main/resources/application.properties` con tus credenciales locales:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/nexus_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=tu_contraseña

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

server.port=8080
```

💡 Asegúrate de que MySQL esté ejecutándose y que la base de datos nexus_db exista.

## 🧰 Ejecución del proyecto

# 1. Clona el repositorio:
```Clona el repositorio:```
# 2. Abre el proyecto en VS Code o IntelliJ IDEA.
# 3. Ejecuta el proyecto.
```mvn spring-boot:run```
# 4. Verifica el backend en: 👉 http://localhost:8080

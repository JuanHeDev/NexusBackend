package com.project.nexus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API de Nexus")
                .version("1.0.0")
                .description("Documentación de la API REST para el proyecto Nexus 🚀")
                .contact(new Contact()
                    .name("Equipo de Desarrollo")
                    .email("contacto@nexus.com")
                    .url("https://nexus.com")));
    }
}

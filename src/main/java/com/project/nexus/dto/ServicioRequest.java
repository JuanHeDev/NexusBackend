package com.project.nexus.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO para crear o actualizar un servicio")
public class ServicioRequest {
    
    @Schema(description = "Título del servicio", example = "Desarrollo Web", required = true)
    private String titulo;
    
    @Schema(description = "Descripción del servicio", example = "Desarrollo de aplicaciones web modernas con React y Spring Boot")
    private String descripcion;
    
    @Schema(description = "URL de la imagen", example = "https://example.com/imagen.jpg")
    private String imagenUrl;
}

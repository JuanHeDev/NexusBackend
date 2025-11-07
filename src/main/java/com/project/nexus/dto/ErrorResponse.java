package com.project.nexus.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO para la respuesta de error")
public class ErrorResponse {
    
    @Schema(description = "Código de estado HTTP", example = "404")
    private int status;
    
    @Schema(description = "Mensaje de error", example = "Servicio no encontrado")
    private String message;
    
    @Schema(description = "Timestamp del error", example = "2024-01-15T10:30:00")
    private String timestamp;
    
    @Schema(description = "Ruta que causó el error", example = "/servicios/999")
    private String path;
    
    public ErrorResponse(int status, String message, String timestamp, String path) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
        this.path = path;
    }
}

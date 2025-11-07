// Ejemplo de validaciones más robustas (no lo voy a aplicar, solo ejemplo)

@Operation(summary = "Crear servicio")
@PostMapping
public ResponseEntity<Object> crearServicio(@RequestBody Servicio servicio) {
    try {
        // Validación de título
        if (servicio.getTitulo() == null || servicio.getTitulo().trim().isEmpty()) {
            return ResponseEntity.badRequest()
                .body(Map.of("error", "El título es requerido"));
        }
        if (servicio.getTitulo().length() > 100) {
            return ResponseEntity.badRequest()
                .body(Map.of("error", "El título no puede exceder 100 caracteres"));
        }
        
        // Validación de descripción
        if (servicio.getDescripcion() == null || servicio.getDescripcion().trim().isEmpty()) {
            return ResponseEntity.badRequest()
                .body(Map.of("error", "La descripción es requerida"));
        }
        if (servicio.getDescripcion().length() > 1000) {
            return ResponseEntity.badRequest()
                .body(Map.of("error", "La descripción no puede exceder 1000 caracteres"));
        }
        
        // Validación de URL de imagen (si se proporciona)
        if (servicio.getImagenUrl() != null && !servicio.getImagenUrl().trim().isEmpty()) {
            if (!isValidUrl(servicio.getImagenUrl())) {
                return ResponseEntity.badRequest()
                    .body(Map.of("error", "La URL de imagen no es válida"));
            }
        }
        
        Servicio servicioGuardado = servicioService.guardarServicio(servicio);
        return ResponseEntity.status(HttpStatus.CREATED).body(servicioGuardado);
        
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(Map.of("error", "Error interno del servidor"));
    }
}

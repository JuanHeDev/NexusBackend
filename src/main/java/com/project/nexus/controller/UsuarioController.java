package com.project.nexus.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.nexus.model.Usuario;
import com.project.nexus.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Usuarios")
@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Operation(summary = "Login de usuario")
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Usuario datosLogin) {
        try {
            // Validar datos básicos
            if (datosLogin.getCorreo() == null || datosLogin.getCorreo().trim().isEmpty()) {
                return ResponseEntity.badRequest()
                    .body(new Respuesta("error", "El correo es requerido"));
            }
            if (datosLogin.getContrasena() == null || datosLogin.getContrasena().trim().isEmpty()) {
                return ResponseEntity.badRequest()
                    .body(new Respuesta("error", "La contraseña es requerida"));
            }
            
            Usuario usuario = usuarioService.verificarLogin(datosLogin.getCorreo(), datosLogin.getContrasena());
            if (usuario == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new Respuesta("error", "Credenciales incorrectas"));
            }
            
            return ResponseEntity.ok(usuario);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new Respuesta("error", "Error interno del servidor"));
        }
    }
    record Respuesta(String status, String mensaje) {}
}

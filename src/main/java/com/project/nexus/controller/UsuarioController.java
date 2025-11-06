package com.project.nexus.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.nexus.model.Usuario;
import com.project.nexus.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public Object login(@RequestBody Usuario datosLogin) {
        Usuario usuario = usuarioService.verificarLogin(datosLogin.getCorreo(), datosLogin.getContrasena());
        if (usuario == null) {
            return new Respuesta("error", "Credenciales incorrectas");
        }
        return usuario;
    }
    record Respuesta(String status, String mensaje) {}
}

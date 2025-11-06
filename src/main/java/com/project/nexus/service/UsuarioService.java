package com.project.nexus.service;

import org.springframework.stereotype.Service;

import com.project.nexus.model.Usuario;
import com.project.nexus.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario verificarLogin(String correo, String contrasena) {
        Usuario usuario = usuarioRepository.findByCorreo(correo);
        if (usuario != null && usuario.getContrasena().equals(contrasena)) {
            return usuario; // credenciales válidas
        }
        return null; // usuario no encontrado o contraseña incorrecta
    }
}

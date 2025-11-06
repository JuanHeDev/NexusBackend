package com.project.nexus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.nexus.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByCorreo(String correo);
}

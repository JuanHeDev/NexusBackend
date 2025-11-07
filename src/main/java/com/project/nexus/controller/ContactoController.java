package com.project.nexus.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.nexus.model.Contacto;
import com.project.nexus.service.ContactoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Contactos")
@RestController
@RequestMapping("/contactos")
@CrossOrigin(origins = "http://localhost:5173")
public class ContactoController {

    private final ContactoService contactoService;

    public ContactoController(ContactoService contactoService) {
        this.contactoService = contactoService;
    }

    @Operation(summary = "Guardar contacto")
    @PostMapping
    public ResponseEntity<Contacto> guardarContacto(@RequestBody Contacto contacto) {
        try {
            // Validar datos básicos
            if (contacto.getNombre() == null || contacto.getNombre().trim().isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            if (contacto.getCorreo() == null || contacto.getCorreo().trim().isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            
            Contacto contactoGuardado = contactoService.guardarContacto(contacto);
            return ResponseEntity.status(HttpStatus.CREATED).body(contactoGuardado);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}

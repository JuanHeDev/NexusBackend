package com.project.nexus.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.nexus.model.Contacto;
import com.project.nexus.service.ContactoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(summary = "Guardar contacto", description = "Registra un nuevo mensaje de contacto")
    @ApiResponse(responseCode = "201", description = "Contacto guardado correctamente")
    @PostMapping
    public Contacto guardarContacto(@RequestBody Contacto contacto) {
        return contactoService.guardarContacto(contacto);
    }

}

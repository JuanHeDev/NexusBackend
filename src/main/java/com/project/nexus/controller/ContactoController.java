package com.project.nexus.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.nexus.model.Contacto;
import com.project.nexus.service.ContactoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/contactos")
@CrossOrigin(origins = "http://localhost:5173")
public class ContactoController {
    
    private final ContactoService contactoService;

    public ContactoController(ContactoService contactoService) {
        this.contactoService = contactoService;
    }

    @PostMapping
    public Contacto guardarContacto(@RequestBody Contacto contacto) {
        return contactoService.guardarContacto(contacto);
    }
    
}

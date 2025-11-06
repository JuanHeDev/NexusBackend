package com.project.nexus.service;

import org.springframework.stereotype.Service;
import com.project.nexus.model.Contacto;
import com.project.nexus.repository.ContactoRepository;

@Service
public class ContactoService {

    private final ContactoRepository contactoRepository;

    public ContactoService(ContactoRepository contactoRepository) {
        this.contactoRepository = contactoRepository;
    }

    public Contacto guardarContacto(Contacto contacto) {
        return contactoRepository.save(contacto);
    }
}

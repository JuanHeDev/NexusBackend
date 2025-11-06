package com.project.nexus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.nexus.model.Contacto;

public interface ContactoRepository extends JpaRepository<Contacto, Long> {   
}
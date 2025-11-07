package com.project.nexus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.nexus.model.Servicio;
import com.project.nexus.repository.ServicioRepository;

@Service
public class ServicioService {
    
    private final ServicioRepository servicioRepository;

    public ServicioService(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    public List<Servicio> listarServicios() {
        return servicioRepository.findAll();
    }

    public Servicio guardarServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    public Servicio actualizarServicio(Long id, Servicio servicio) {
        Servicio existente = servicioRepository.findById(id).orElseThrow();
        existente.setTitulo(servicio.getTitulo());
        existente.setDescripcion(servicio.getDescripcion());
        existente.setImagenUrl(servicio.getImagenUrl());
        return servicioRepository.save(existente);
    }

    public void eliminarServicio(Long id) {
        servicioRepository.deleteById(id);
    }
}

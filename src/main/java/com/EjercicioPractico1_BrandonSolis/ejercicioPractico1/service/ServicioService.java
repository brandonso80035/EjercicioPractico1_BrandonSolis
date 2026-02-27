/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.EjercicioPractico1_BrandonSolis.ejercicioPractico1.service;

import com.EjercicioPractico1_BrandonSolis.ejercicioPractico1.domain.Servicio;
import com.EjercicioPractico1_BrandonSolis.ejercicioPractico1.repository.ServicioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author bsoli
 */
@Service
public class ServicioService {

    private final ServicioRepository servicioRepository;

    public ServicioService(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    @Transactional(readOnly = true)
    public List<Servicio> getServicios() {
        return servicioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Servicio> getServicio(Integer id) {
        return servicioRepository.findById(id);
    }

    @Transactional
    public void save(Servicio servicio) {
        servicioRepository.save(servicio);
    }

    @Transactional
    public void delete(Integer id) {
        if (!servicioRepository.existsById(id)) {
            throw new IllegalArgumentException("El servicio con ID " + id + " no existe.");
        }
        try {
            servicioRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("No se puede eliminar el servicio. Tiene reservas asociadas.", e);
        }
    }
}
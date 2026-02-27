/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.EjercicioPractico1_BrandonSolis.ejercicioPractico1.repository;

import com.EjercicioPractico1_BrandonSolis.ejercicioPractico1.domain.Servicio;  
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bsoli
 */
@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
}

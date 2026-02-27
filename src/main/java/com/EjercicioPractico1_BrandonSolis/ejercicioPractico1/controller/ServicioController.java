/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.EjercicioPractico1_BrandonSolis.controller;

import com.EjercicioPractico1_BrandonSolis.ejercicioPractico1.domain.Servicio;
import com.EjercicioPractico1_BrandonSolis.ejercicioPractico1.service.CategoriaService; 
import com.EjercicioPractico1_BrandonSolis.ejercicioPractico1.service.ServicioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author bsoli
 */
@Controller
@RequestMapping("/servicio")
public class ServicioController {

    private final ServicioService servicioService;
    private final CategoriaService categoriaService;

    public ServicioController(ServicioService servicioService, CategoriaService categoriaService) {
        this.servicioService = servicioService;
        this.categoriaService = categoriaService;
    }

    @GetMapping("/listado")
    public String listado(Model model) {
        var servicios = servicioService.getServicios();
        model.addAttribute("servicios", servicios);
        return "servicio/listado";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        var categorias = categoriaService.getCategorias();
        model.addAttribute("categorias", categorias);
        return "servicio/modifica";
    }

    @PostMapping("/guardar")
    public String guardar(Servicio servicio) {
        servicioService.save(servicio);
        return "redirect:/servicio/listado";
    }

    @GetMapping("/modificar")
    public String modificar(@RequestParam Integer id, Model model) {
        var servicio = servicioService.getServicio(id)
                .orElseThrow(() -> new IllegalArgumentException("Servicio no encontrado"));
        var categorias = categoriaService.getCategorias();
        model.addAttribute("servicio", servicio);
        model.addAttribute("categorias", categorias);
        return "servicio/modifica";
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam Integer id) {
        servicioService.delete(id);
        return "redirect:/servicio/listado";
    }
}

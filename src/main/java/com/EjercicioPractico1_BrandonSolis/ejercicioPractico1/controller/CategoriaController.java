/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.EjercicioPractico1_BrandonSolis.controller;

import com.EjercicioPractico1_BrandonSolis.ejercicioPractico1.domain.Categoria;
import com.EjercicioPractico1_BrandonSolis.ejercicioPractico1.service.CategoriaService;
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
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/listado")
    public String listado(Model model) {
        var categorias = categoriaService.getCategorias();
        model.addAttribute("categorias", categorias);
        return "categoria/listado";
    }

    @GetMapping("/nuevo")
    public String nuevo() {
        return "categoria/modifica";
    }

    @PostMapping("/guardar")
    public String guardar(Categoria categoria) {
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/modificar")
    public String modificar(@RequestParam Integer id, Model model) {
        var categoria = categoriaService.getCategoria(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada"));
        model.addAttribute("categoria", categoria);
        return "categoria/modifica";
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam Integer id) {
        categoriaService.delete(id);
        return "redirect:/categoria/listado";
    }
}

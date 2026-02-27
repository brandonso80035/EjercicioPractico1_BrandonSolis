/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.EjercicioPractico1_BrandonSolis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author bsoli
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @GetMapping("/contacto")
    public String contacto() {
        return "contacto";
    }
}

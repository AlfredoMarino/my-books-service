package com.alfredomarino.mislibros.core.controller;

import org.springframework.web.bind.annotation.RestController;

import com.alfredomarino.mislibros.core.business.services.LibroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * LibroController
 */
@RestController
@RequestMapping("/v1/libro")
public class LibroController {

    LibroService libroService;

    @Autowired
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    
    @GetMapping
    public String getLibro() {

        libroService.createLibro("prueba");

        return "hola mundo";
    }
    
}
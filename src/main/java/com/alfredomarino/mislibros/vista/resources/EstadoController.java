package com.alfredomarino.mislibros.vista.resources;

import java.util.List;

import com.alfredomarino.mislibros.modelo.Estado;
import com.alfredomarino.mislibros.negocio.services.EstadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EstadoController
 */
@RestController
@RequestMapping("/v1/estado")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public ResponseEntity<List<Estado>> getEstados(){
        
        return new ResponseEntity<List<Estado>>(this.estadoService.findAll(), HttpStatus.OK);
    }
    
}
package com.alfredomarino.mislibros.core.controller.resources;

import java.util.List;

import com.alfredomarino.mislibros.core.model.Pais;
import com.alfredomarino.mislibros.core.business.services.PaisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PaisController
 */
@RestController
@RequestMapping("/v1/pais")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping
    public ResponseEntity<List<Pais>> getPaises(){
        
        return new ResponseEntity<List<Pais>>(this.paisService.findAll(), HttpStatus.OK);
    }
    
}
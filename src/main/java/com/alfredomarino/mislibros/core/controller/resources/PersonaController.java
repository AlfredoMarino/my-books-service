package com.alfredomarino.mislibros.core.controller.resources;

import java.util.List;

import com.alfredomarino.mislibros.core.model.Persona;
import com.alfredomarino.mislibros.core.business.services.PersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * PersonaController
 */
@RestController
@RequestMapping(value = "/v1/persona")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping
    public ResponseEntity<List<Persona>>  getPersonaByNombreOrApellido(
        @RequestParam String nombre,
        @RequestParam String apellido
    ) {
        return new ResponseEntity<List<Persona>>(this.personaService.findAllByNombreOrApellido(nombre, apellido), HttpStatus.OK);
    }
    
}
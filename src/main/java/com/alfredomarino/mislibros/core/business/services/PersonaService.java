package com.alfredomarino.mislibros.core.business.services;

import java.util.List;

import com.alfredomarino.mislibros.core.model.Persona;
import com.alfredomarino.mislibros.core.business.repository.PersonaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PersonaService
 */
@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    public List<Persona> findAllByNombreOrApellido(String nombre, String apellido){
        return this.personaRepository.findAllByNombreOrApellido(nombre, apellido);
    }
}
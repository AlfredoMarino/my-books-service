package com.alfredomarino.mislibros.negocio.services;

import java.util.List;

import com.alfredomarino.mislibros.modelo.Persona;
import com.alfredomarino.mislibros.negocio.repository.PersonaRepository;

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
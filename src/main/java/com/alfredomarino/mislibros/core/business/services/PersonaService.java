package com.alfredomarino.mislibros.core.business.services;

import com.alfredomarino.mislibros.core.model.Persona;

import java.util.List;

public interface PersonaService {

    List<Persona> findAllByNombreOrApellido(String nombre, String apellido);

}

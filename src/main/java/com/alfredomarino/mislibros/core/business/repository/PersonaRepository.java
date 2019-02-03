package com.alfredomarino.mislibros.core.business.repository;

import java.util.List;

import com.alfredomarino.mislibros.core.model.Persona;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PersonaRepository
 */
public interface PersonaRepository  extends JpaRepository<Persona, Long>{

    public List<Persona> findAllByNombreOrApellido(String nombre, String apellido);
}
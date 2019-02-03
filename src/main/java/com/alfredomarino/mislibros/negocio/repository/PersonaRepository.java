package com.alfredomarino.mislibros.negocio.repository;

import java.util.List;

import com.alfredomarino.mislibros.modelo.Persona;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PersonaRepository
 */
public interface PersonaRepository  extends JpaRepository<Persona, Long>{

    public List<Persona> findAllByNombreOrApellido(String nombre, String apellido);
}
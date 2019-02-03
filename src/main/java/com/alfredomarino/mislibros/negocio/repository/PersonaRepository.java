package com.alfredomarino.mislibros.negocio.repository;

import com.alfredomarino.mislibros.modelo.Persona;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PersonaRepository
 */
public interface PersonaRepository  extends JpaRepository<Persona, Long>{

    
}
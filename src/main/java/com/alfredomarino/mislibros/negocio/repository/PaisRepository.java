package com.alfredomarino.mislibros.negocio.repository;

import java.util.List;

import com.alfredomarino.mislibros.modelo.Pais;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PaisRepository
 */
@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

    public List<Pais> findAll();
    
}
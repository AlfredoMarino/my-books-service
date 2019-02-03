package com.alfredomarino.mislibros.core.business.repository;

import java.util.List;

import com.alfredomarino.mislibros.core.model.Estado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * EstadoRepository
 */
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    public List<Estado> findAll();
    
}
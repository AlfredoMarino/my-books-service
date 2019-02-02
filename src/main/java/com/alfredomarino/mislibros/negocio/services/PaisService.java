package com.alfredomarino.mislibros.negocio.services;

import java.util.List;

import com.alfredomarino.mislibros.modelo.Pais;
import com.alfredomarino.mislibros.negocio.repository.PaisRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PaisService
 */
@Service
public class PaisService {

    @Autowired
    private PaisRepository paisRepository;

    public List<Pais> findAll(){
        return this.paisRepository.findAll();
    }
    
}
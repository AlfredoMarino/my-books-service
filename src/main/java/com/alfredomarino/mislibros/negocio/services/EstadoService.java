package com.alfredomarino.mislibros.negocio.services;

import java.util.List;

import com.alfredomarino.mislibros.modelo.Estado;
import com.alfredomarino.mislibros.negocio.repository.EstadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * EstadoService
 */
@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> findAll(){
        return this.estadoRepository.findAll();
    }
    
}
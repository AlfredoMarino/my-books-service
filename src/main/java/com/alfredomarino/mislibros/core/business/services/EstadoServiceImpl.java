package com.alfredomarino.mislibros.core.business.services;

import java.util.List;

import com.alfredomarino.mislibros.core.model.Estado;
import com.alfredomarino.mislibros.core.business.repository.EstadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * EstadoServiceImpl
 */
@Service
public class EstadoServiceImpl implements EstadoService {

    private EstadoRepository estadoRepository;

    @Autowired
    public EstadoServiceImpl(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @Override
    public List<Estado> findAll(){
        return this.estadoRepository.findAll();
    }
    
}
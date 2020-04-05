package com.alfredomarino.mybooks.core.business.services;

import java.util.List;

import com.alfredomarino.mybooks.core.business.repository.RegionRepository;
import com.alfredomarino.mybooks.core.model.Region;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RegionServiceImpl
 */
@Service
public class RegionServiceImpl implements RegionService {

    private RegionRepository regionRepository;

    @Autowired
    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public List<Region> findAll(){
        return this.regionRepository.findAll();
    }
    
}
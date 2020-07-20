package com.alfredomarino.mybooks.core.services.impl;

import java.util.List;

import com.alfredomarino.mybooks.core.repository.RegionRepository;
import com.alfredomarino.mybooks.core.services.RegionService;
import com.alfredomarino.mybooks.core.model.Region;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RegionServiceImpl
 */
@Service
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;

    @Autowired
    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public List<Region> getRegionsByCountryId(Long countryId) {
        return this.regionRepository.findByCountryCountryId(countryId);
    }
}
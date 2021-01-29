package com.alfredomarino.mybooks.core.services.impl;

import java.util.List;

import com.alfredomarino.mybooks.core.repository.CountryRepository;
import com.alfredomarino.mybooks.core.services.CountryService;
import com.alfredomarino.mybooks.core.model.Country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CountryService
 */
@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getCountries(){
        return this.countryRepository.findAll();
    }
    
}
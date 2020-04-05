package com.alfredomarino.mybooks.core.business.services;

import java.util.List;

import com.alfredomarino.mybooks.core.business.repository.CountryRepository;
import com.alfredomarino.mybooks.core.model.Country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CountryService
 */
@Service
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll(){
        return this.countryRepository.findAll();
    }
    
}
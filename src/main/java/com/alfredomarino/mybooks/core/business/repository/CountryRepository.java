package com.alfredomarino.mybooks.core.business.repository;

import java.util.List;

import com.alfredomarino.mybooks.core.model.Country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CountryRepository
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    public List<Country> findAll();
    
}
package com.alfredomarino.mybooks.core.repository;

import com.alfredomarino.mybooks.core.model.Country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CountryRepository
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
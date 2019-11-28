package com.alfredomarino.mybooks.core.business.repository;

import java.util.List;

import com.alfredomarino.mybooks.core.model.Region;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * RegionRepository
 */
@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

    public List<Region> findAll();
    
}
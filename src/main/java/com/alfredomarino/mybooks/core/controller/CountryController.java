package com.alfredomarino.mybooks.core.controller;

import java.util.List;

import com.alfredomarino.mybooks.core.model.Region;
import com.alfredomarino.mybooks.core.services.CountryService;
import com.alfredomarino.mybooks.core.model.Country;

import com.alfredomarino.mybooks.core.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CountryController
 */
@RestController
@RequestMapping("/v1/countries")
public class CountryController {

    private CountryService countryService;
    private RegionService regionService;

    @Autowired
    public CountryController(CountryService countryService, RegionService regionService) {
        this.countryService = countryService;
        this.regionService = regionService;
    }

    @GetMapping
    public ResponseEntity<List<Country>> getCountries(){
        return new ResponseEntity<>(this.countryService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{countryId}/regions")
    public ResponseEntity<List<Region>> getRegionsByCountryId(@PathVariable Long countryId){
        return new ResponseEntity<>(this.regionService.findByCountryId(countryId), HttpStatus.OK);
    }
    
}
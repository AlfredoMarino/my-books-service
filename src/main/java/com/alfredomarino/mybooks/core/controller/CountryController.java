package com.alfredomarino.mybooks.core.controller;

import java.util.List;

import com.alfredomarino.mybooks.core.services.CountryService;
import com.alfredomarino.mybooks.core.model.Country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CountryController
 */
@RestController
@RequestMapping("/v1/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public ResponseEntity<List<Country>> getCountries(){
        
        return new ResponseEntity<List<Country>>(this.countryService.findAll(), HttpStatus.OK);
    }
    
}
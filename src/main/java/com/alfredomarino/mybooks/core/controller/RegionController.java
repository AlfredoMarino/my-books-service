package com.alfredomarino.mybooks.core.controller;

import java.util.List;

import com.alfredomarino.mybooks.core.business.services.RegionService;
import com.alfredomarino.mybooks.core.model.Region;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RegionController
 */
@RestController
@RequestMapping("/v1/region")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping
    public ResponseEntity<List<Region>> getRegion(){
        
        return new ResponseEntity<List<Region>>(this.regionService.findAll(), HttpStatus.OK);
        
    }
    
}
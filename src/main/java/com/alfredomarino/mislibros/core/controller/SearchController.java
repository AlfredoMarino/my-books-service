package com.alfredomarino.mislibros.core.controller;

import com.alfredomarino.mislibros.core.business.services.SearchService;
import com.alfredomarino.mislibros.core.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/search")
public class SearchController {

    public SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping
    public ResponseEntity<List<Libro>> searchByName(
            @RequestParam(value = "name", required = false) String name
    ) throws Exception {
        List<Libro> libros = new ArrayList<>();
        if (name != null){
            libros = this.searchService.getBooksByName(name);
        }

        return new ResponseEntity<List<Libro>>(libros, HttpStatus.OK);
    }
}

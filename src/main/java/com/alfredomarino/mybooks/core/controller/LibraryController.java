package com.alfredomarino.mybooks.core.controller;

import com.alfredomarino.mybooks.core.services.LibraryService;
import com.alfredomarino.mybooks.core.model.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/library")
public class LibraryController {

    LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping
    public ResponseEntity<Library> create(@RequestBody Library library) throws Exception {
        return new ResponseEntity<Library>(this.libraryService.create(library), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Library>> getLibrariesByPersonId(@RequestParam int idPerson) {
        return new ResponseEntity<List<Library>>(this.libraryService.findByPersonId(idPerson), HttpStatus.OK);
    }
}

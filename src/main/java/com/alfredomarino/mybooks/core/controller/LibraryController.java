package com.alfredomarino.mybooks.core.controller;

import com.alfredomarino.mybooks.core.business.services.LibraryService;
import com.alfredomarino.mybooks.core.model.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/library")
public class LibraryController {

    LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping
    public ResponseEntity<Library> create(@RequestBody Library library) {
        return new ResponseEntity<Library>(this.libraryService.create(library), HttpStatus.CREATED);
    }
}

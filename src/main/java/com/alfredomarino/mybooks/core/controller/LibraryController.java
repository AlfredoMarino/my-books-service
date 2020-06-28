package com.alfredomarino.mybooks.core.controller;

import java.util.List;

import com.alfredomarino.mybooks.core.model.Book;
import com.alfredomarino.mybooks.core.model.Library;
import com.alfredomarino.mybooks.core.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * LibraryController
 */
@RestController
@RequestMapping(value = "/v1/persons/{personId}/libraries")
public class LibraryController {

    private LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public ResponseEntity<List<Library>> getLibrariesByPersonId(@PathVariable Long personId) {
        return new ResponseEntity<>(this.libraryService.getLibrariesByPersonId(personId), HttpStatus.OK);
    }

    @GetMapping(value = "/books")
    public ResponseEntity<List<Book>> getBooksByPersonId(@PathVariable Long personId) {
        return new ResponseEntity<>(this.libraryService.getBooksByPersonId(personId), HttpStatus.OK);
    }

    @PostMapping(value = "/{googleId}")
    public ResponseEntity<Library> create(@PathVariable Long personId, @PathVariable String googleId, @RequestBody Library library) {
        return new ResponseEntity<>(this.libraryService.create(personId, googleId, library), HttpStatus.CREATED);
    }
}
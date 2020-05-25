package com.alfredomarino.mybooks.core.controller;

import java.util.List;

import com.alfredomarino.mybooks.core.model.Library;
import com.alfredomarino.mybooks.core.services.LibraryService;
import com.alfredomarino.mybooks.core.services.PersonService;
import com.alfredomarino.mybooks.core.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * PersonController
 */
@RestController
@RequestMapping(value = "/v1/persons")
public class PersonController {

    private PersonService personService;
    private LibraryService libraryService;

    @Autowired
    public PersonController(PersonService personService, LibraryService libraryService) {
        this.personService = personService;
        this.libraryService = libraryService;
    }

    @GetMapping
    public ResponseEntity<List<Person>>  getPersonByNameOrLastname(@RequestParam String name, @RequestParam String lastname) {
        return new ResponseEntity<>(this.personService.findAllByNameOrLastname(name, lastname), HttpStatus.OK);
    }

    @PostMapping(value = "/{personId}/libraries/{googleId}")
    public ResponseEntity<Library> create(@PathVariable Long personId, @PathVariable String googleId, @RequestBody Library library) {
        return new ResponseEntity<>(this.libraryService.create(personId, googleId, library), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{personId}/libraries")
    public ResponseEntity<List<Library>> getLibrariesByPersonId(@PathVariable Long personId) {
        return new ResponseEntity<>(this.libraryService.findByPersonId(personId), HttpStatus.OK);
    }
}
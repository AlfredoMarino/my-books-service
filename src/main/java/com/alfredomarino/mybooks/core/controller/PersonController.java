package com.alfredomarino.mybooks.core.controller;

import java.util.List;

import com.alfredomarino.mybooks.core.business.services.PersonService;
import com.alfredomarino.mybooks.core.business.services.UserService;
import com.alfredomarino.mybooks.core.model.Person;

import com.alfredomarino.mybooks.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * PersonController
 */
@RestController
@RequestMapping(value = "/v1/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Person>>  getPersonByNameOrLastname(
        @RequestParam String name,
        @RequestParam String lastname
    ) {
        return new ResponseEntity<List<Person>>(this.personService.findAllByNameOrLastname(name, lastname), HttpStatus.OK);
    }
    
}
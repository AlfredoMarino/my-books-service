package com.alfredomarino.mybooks.core.services.impl;

import java.util.List;

import com.alfredomarino.mybooks.core.services.PersonService;
import com.alfredomarino.mybooks.core.model.Person;
import com.alfredomarino.mybooks.core.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PersonServiceImpl
 */
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person getPersonById(Long personId) {
        return this.personRepository.findById(personId).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Person> getPersonsByNameOrLastName(String name, String lastName){
        return this.personRepository.findAllByNameOrLastName(name, lastName);
    }
}
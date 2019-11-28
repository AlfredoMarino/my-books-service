package com.alfredomarino.mybooks.core.business.services;

import java.util.List;

import com.alfredomarino.mybooks.core.model.Person;
import com.alfredomarino.mybooks.core.business.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PersonServiceImpl
 */
@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAllByNameOrLastname(String name, String lastname){
        return this.personRepository.findAllByNameOrLastname(name, lastname);
    }
}
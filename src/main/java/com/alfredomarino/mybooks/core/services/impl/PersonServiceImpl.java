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

    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public boolean existsById(Long idPerson) {
        return this.personRepository.existsById(idPerson);
    }

    @Override
    public List<Person> findAllByNameOrLastname(String name, String lastname){
        return this.personRepository.findAllByNameOrLastname(name, lastname);
    }

    @Override
    public Person create(Person person){
        return this.personRepository.save(person);
    }
}
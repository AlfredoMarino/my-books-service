package com.alfredomarino.mybooks.core.services;

import com.alfredomarino.mybooks.core.model.Person;

import java.util.List;

public interface PersonService {

    Person getPersonById(Long personId);

    boolean existsById(Long idPerson);

    List<Person> getPersonsByNameOrLastname(String name, String lastname);

    Person create(Person person);
}

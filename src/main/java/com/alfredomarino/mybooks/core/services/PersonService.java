package com.alfredomarino.mybooks.core.services;

import com.alfredomarino.mybooks.core.model.Person;

import java.util.List;

public interface PersonService {

    Person getPersonById(Long personId);

    List<Person> getPersonsByNameOrLastName(String name, String lastName);
}

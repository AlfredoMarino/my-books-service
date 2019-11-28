package com.alfredomarino.mybooks.core.business.services;

import com.alfredomarino.mybooks.core.model.Person;

import java.util.List;

public interface PersonService {

    List<Person> findAllByNameOrLastname(String name, String lastname);

}

package com.alfredomarino.mybooks.core.repository;

import java.util.List;

import com.alfredomarino.mybooks.core.model.Person;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PersonRepository
 */
public interface PersonRepository extends JpaRepository<Person, Long>{

    List<Person> findAllByNameOrLastname(String name, String lastname);
}
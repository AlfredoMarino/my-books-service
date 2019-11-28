package com.alfredomarino.mybooks.core.business.repository;

import java.util.List;

import com.alfredomarino.mybooks.core.model.Person;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PersonRepository
 */
public interface PersonRepository extends JpaRepository<Person, Long>{

    public List<Person> findAllByNameOrLastname(String name, String lastname);
}
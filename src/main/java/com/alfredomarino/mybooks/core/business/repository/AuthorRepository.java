package com.alfredomarino.mybooks.core.business.repository;

import com.alfredomarino.mybooks.core.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findAuthorByName(String name);
}

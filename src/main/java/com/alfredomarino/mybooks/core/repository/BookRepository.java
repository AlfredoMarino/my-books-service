package com.alfredomarino.mybooks.core.repository;

import com.alfredomarino.mybooks.core.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * BookRepository
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByGoogleId(String googleId);

    boolean existsByGoogleId(String googleId);

}

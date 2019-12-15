package com.alfredomarino.mybooks.core.business.repository;

import com.alfredomarino.mybooks.core.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}

package com.alfredomarino.mybooks.core.repository;

import com.alfredomarino.mybooks.core.model.Library;
import com.alfredomarino.mybooks.core.model.LibraryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * LibraryRepository
 */
@Repository
public interface LibraryRepository extends JpaRepository<Library, LibraryId> {

    List<Library> findByPersonPersonId(Long personId);

    List<Library> findByBookBookId(Long bookId);

}

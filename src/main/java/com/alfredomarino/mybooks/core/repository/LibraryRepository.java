package com.alfredomarino.mybooks.core.repository;

import com.alfredomarino.mybooks.core.model.Library;
import com.alfredomarino.mybooks.core.model.LibraryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library, LibraryId> {

    //Library findAll(int idPerson);
}

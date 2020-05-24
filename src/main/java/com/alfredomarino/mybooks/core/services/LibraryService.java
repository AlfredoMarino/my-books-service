package com.alfredomarino.mybooks.core.services;

import com.alfredomarino.mybooks.core.model.Library;

import java.util.List;

public interface LibraryService {

    Library create(Library library) throws Exception;

    List<Library> findByPersonId(int idPerson);
}

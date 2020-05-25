package com.alfredomarino.mybooks.core.services;

import com.alfredomarino.mybooks.core.model.Library;

import java.util.List;

public interface LibraryService {

    Library create(Long personId, String googleId, Library library);

    List<Library> findByPersonId(Long personId);
}

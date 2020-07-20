package com.alfredomarino.mybooks.core.services;

import com.alfredomarino.mybooks.core.model.Author;

public interface AuthorService {

    Author createAuthorIfNotExist(Author author);
}

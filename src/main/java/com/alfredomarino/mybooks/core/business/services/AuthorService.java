package com.alfredomarino.mybooks.core.business.services;

import com.alfredomarino.mybooks.core.model.Author;

public interface AuthorService {

    Author createIfNotExist(Author author);
}

package com.alfredomarino.mybooks.core.services.impl;

import com.alfredomarino.mybooks.core.repository.AuthorRepository;
import com.alfredomarino.mybooks.core.services.AuthorService;
import com.alfredomarino.mybooks.core.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author getAuthorByName(String name) {
        return this.authorRepository.findAuthorByName(name);
    }
}

package com.alfredomarino.mybooks.core.business.services;

import com.alfredomarino.mybooks.core.business.repository.AuthorRepository;
import com.alfredomarino.mybooks.core.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author createIfNotExist(Author author){
        Author savedAuthor = this.authorRepository.findAuthorByName(author.getName());
        return (savedAuthor != null) ? savedAuthor : this.authorRepository.save(author);
    }
}

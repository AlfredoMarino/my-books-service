package com.alfredomarino.mybooks.core.services;

import com.alfredomarino.mybooks.core.model.Book;

public interface BookService {

    Book create(Book book);

    Book createByGoogleId(String googleId);

    Book getBookByGoogleId(String googleId);

    Book getBookById(Long bookId);

    Book getOrCreateBookIfNotExist(String googleId);

    void delete(Long bookId);
}

package com.alfredomarino.mybooks.core.services;

import com.alfredomarino.mybooks.core.model.Book;

public interface BookService {

    Book createBook(Book book);

    Book createBook(String googleId);

    Book getBookByGoogleId(String googleId);

    Book getBookById(Long bookId);

    void deleteBookById(Long bookId);
}

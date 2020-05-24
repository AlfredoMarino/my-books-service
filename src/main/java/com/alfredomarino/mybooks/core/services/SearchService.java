package com.alfredomarino.mybooks.core.services;

import com.alfredomarino.mybooks.core.model.Book;

import java.util.List;

public interface SearchService {
    List<Book> getBooksByName(String name);

    Book getBookByGoogleId(String googleId);
}

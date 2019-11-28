package com.alfredomarino.mybooks.core.business.services;

import com.alfredomarino.mybooks.core.model.Book;

import java.util.List;

public interface SearchService {
    public List<Book> getBooksByName(String name) throws Exception;
}

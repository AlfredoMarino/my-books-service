package com.alfredomarino.mybooks.core.services;

import com.alfredomarino.mybooks.core.model.Book;

public interface BookService {

    Book create(Book book);

    Book createByGoogleId(String idGoogle) throws Exception;

    Book getBookByGoogleId(String idGoogle);

    Book getBookOrCreateIfNotExist(Book book) throws Exception;
}

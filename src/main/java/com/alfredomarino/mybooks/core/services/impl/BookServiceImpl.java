package com.alfredomarino.mybooks.core.services.impl;

import com.alfredomarino.mybooks.core.repository.BookRepository;
import com.alfredomarino.mybooks.core.services.*;
import com.alfredomarino.mybooks.core.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BookServiceImpl
 */
@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private AuthorService authorService;
    private CategoryService categoryService;
    private SearchService searchService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService, SearchService searchService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.searchService = searchService;
    }

    @Override
    public Book create(Book book) {
        System.out.println("book antes ===============================> " + book);

        book.setAuthor(this.authorService.createIfNotExist(book.getAuthor()));

        book.setCategory(this.categoryService.createIfNotExist(book.getCategory()));

        System.out.println("book despues ===============================> " + book);
        return this.bookRepository.save(book);
    }

    @Override
    public Book createByGoogleId(String idGoogle) {

        if (this.bookRepository.findAllByIdGoogle(idGoogle) != null){
            throw new RuntimeException("Book already exists");
        }

        return this.create(this.searchService.getBookByGoogleId(idGoogle));
    }

    @Override
    public Book getBookByGoogleId(String idGoogle) {
        return this.bookRepository.findAllByIdGoogle(idGoogle);
    }

    @Override
    public Book getOrCreateBookIfNotExist(String googleId) {
        Book book = this.getBookByGoogleId(googleId);
        if (book == null) {
            book = this.createByGoogleId(googleId);
        }
        return book;
    }

    @Override
    public Book getBookOrCreateIfNotExist(Book book) {

        if (book.getIdBook() == null && book.getIdGoogle() == null) {
            throw new RuntimeException("The book has no identifiers to search for it");
        }
        Book newBook = null;

        if (book.getIdBook() != null) {
            newBook = this.bookRepository.findById(book.getIdBook()).orElse(null);
        }

        if (newBook == null) {
            newBook = this.getBookByGoogleId(book.getIdGoogle());
            if (newBook == null) {
                newBook = this.createByGoogleId(book.getIdGoogle());
            }
        }

        return newBook;
    }
}
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
    public Book createByGoogleId(String googleId) {

        if (this.bookRepository.findByGoogleId(googleId) != null){
            throw new RuntimeException("Book already exists");
        }

        return this.create(this.searchService.getBookByGoogleId(googleId));
    }

    @Override
    public Book getBookByGoogleId(String googleId) {
        return this.bookRepository.findByGoogleId(googleId);
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

        if (book.getBookId() == null && book.getGoogleId() == null) {
            throw new RuntimeException("The book has no identifiers to search for it");
        }
        Book newBook = null;

        if (book.getBookId() != null) {
            newBook = this.bookRepository.findById(book.getBookId()).orElse(null);
        }

        if (newBook == null) {
            newBook = this.getBookByGoogleId(book.getGoogleId());
            if (newBook == null) {
                newBook = this.createByGoogleId(book.getGoogleId());
            }
        }

        return newBook;
    }
}
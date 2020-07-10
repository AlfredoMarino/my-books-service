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

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final SearchService searchService;

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
    public Book getBookById(Long bookId) {
        return this.bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException(String.format("Book '%s' not found", bookId)));
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
    public void delete(Long bookId) {
        Book book = this.getBookById(bookId);
        this.bookRepository.delete(book);
    }
}
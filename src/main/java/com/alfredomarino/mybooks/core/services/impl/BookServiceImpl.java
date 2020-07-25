package com.alfredomarino.mybooks.core.services.impl;

import com.alfredomarino.mybooks.core.model.Author;
import com.alfredomarino.mybooks.core.repository.BookRepository;
import com.alfredomarino.mybooks.core.services.*;
import com.alfredomarino.mybooks.core.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

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
    public Book createBook(Book book) {
        book.setAuthors(book.getAuthors().stream().map(author -> {
            Author savedAuthor = this.authorService.getAuthorByName(author.getName());
            return savedAuthor != null ? savedAuthor : author;
        }).collect(Collectors.toList()));
        book.setCategory(this.categoryService.createCategoryIfNotExist(book.getCategory()));
        return this.bookRepository.save(book);
    }

    @Override
    public Book createBook(String googleId) {
        if (this.bookRepository.findByGoogleId(googleId) != null){
            throw new RuntimeException("Book already exists");
        }

        return this.createBook(this.searchService.getBookByGoogleId(googleId));
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
    public void deleteBook(Long bookId) {
        Book book = this.getBookById(bookId);
        this.bookRepository.delete(book);
    }
}
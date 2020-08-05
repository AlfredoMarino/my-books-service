package com.alfredomarino.mybooks.core.services.impl;

import com.alfredomarino.mybooks.core.model.Author;
import com.alfredomarino.mybooks.core.model.Category;
import com.alfredomarino.mybooks.core.repository.BookRepository;
import com.alfredomarino.mybooks.core.services.*;
import com.alfredomarino.mybooks.core.model.Book;
import com.alfredomarino.mybooks.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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
        if (book.getAuthors() != null) {
            book.setAuthors(book.getAuthors().stream().map(author -> {
                Author savedAuthor = this.authorService.getAuthorByName(author.getName());
                return savedAuthor != null ? savedAuthor : author;
            }).collect(Collectors.toList()));
        }
        if (book.getCategories() != null) {
            book.setCategories(book.getCategories().stream().map(category -> {
                Category savedCategory = this.categoryService.getCategoryByName(category.getName());
                return savedCategory != null ? savedCategory : category;
            }).collect(Collectors.toList()));
        }

        return this.bookRepository.save(book);
    }

    @Override
    public Book createBook(String googleId) {
        Assert.isTrue(!this.bookRepository.existsByGoogleId(googleId), "Book already exists");

        return this.createBook(this.searchService.getBookByGoogleId(googleId));
    }

    @Override
    public Book getBookByGoogleId(String googleId) {
        return this.bookRepository.findByGoogleId(googleId);
    }

    @Override
    public Book getBookById(Long bookId) {
        return this.bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundException(String.format("Book '%s' not found", bookId)));
    }

    @Override
    public void deleteBook(Long bookId) {
        Book book = this.getBookById(bookId);
        this.bookRepository.delete(book);
    }
}
package com.alfredomarino.mybooks.core.business.services;

import com.alfredomarino.mybooks.core.business.repository.AuthorRepository;
import com.alfredomarino.mybooks.core.business.repository.BookRepository;
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

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public Book create(Book book) {
        System.out.println("book antes ===============================> " + book);

        book.setAuthor(this.authorService.createIfNotExist(book.getAuthor()));

        book.setCategory(this.categoryService.createIfNotExist(book.getCategory()));

        System.out.println("book despues ===============================> " + book);
        return this.bookRepository.save(book);
    }
}
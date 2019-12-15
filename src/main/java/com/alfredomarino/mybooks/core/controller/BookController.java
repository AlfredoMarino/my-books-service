package com.alfredomarino.mybooks.core.controller;

import com.alfredomarino.mybooks.core.business.services.BookService;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * BookController
 */
@RestController
@RequestMapping("/v1/book")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    
    @GetMapping
    public String getBook() {
        return "hola mundo";
    }
    
}
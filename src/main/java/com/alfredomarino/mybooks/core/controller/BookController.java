package com.alfredomarino.mybooks.core.controller;

import com.alfredomarino.mybooks.core.model.Book;
import com.alfredomarino.mybooks.core.services.BookService;
import com.alfredomarino.mybooks.core.services.SearchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


/**
 * BookController
 */
@RestController
@RequestMapping("/v1/books")
public class BookController {

    private BookService bookService;
    private SearchService searchService;

    @Autowired
    public BookController(BookService bookService, SearchService searchService) {
        this.bookService = bookService;
        this.searchService = searchService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(
            @RequestParam(value = "name", required = false) String name
    ) {
        List<Book> books = new ArrayList<>();
        if (name != null){
            books = this.searchService.getBooksByName(name);
        }

        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    
}
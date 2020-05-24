package com.alfredomarino.mybooks.core.controller;

import com.alfredomarino.mybooks.core.services.SearchService;
import com.alfredomarino.mybooks.core.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/search")
public class SearchController {

    public SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> searchByName(
            @RequestParam(value = "name", required = false) String name
    ) throws Exception {
        List<Book> books = new ArrayList<>();
        if (name != null){
            books = this.searchService.getBooksByName(name);
        }

        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }
}

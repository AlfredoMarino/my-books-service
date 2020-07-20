package com.alfredomarino.mybooks.core.controller;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.books.Books;
import com.google.api.services.books.model.Volume;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/search")
public class SearchController {

    @GetMapping
    public ResponseEntity<List<Volume>> searchByName(@RequestParam(value = "name") String name) throws GeneralSecurityException, IOException {
        final Books googleBooksServiceClient = new Books(GoogleNetHttpTransport.newTrustedTransport(), new JacksonFactory(), null);
        return new ResponseEntity<>(googleBooksServiceClient.volumes().list(name).execute().getItems(), HttpStatus.OK);
    }
}

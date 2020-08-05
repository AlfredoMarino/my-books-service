package com.alfredomarino.mybooks.core.services.impl;

import com.alfredomarino.mybooks.core.model.Book;
import com.alfredomarino.mybooks.core.services.SearchService;
import com.alfredomarino.mybooks.core.utils.functions.IsVolumeComplete;
import com.alfredomarino.mybooks.core.utils.functions.VolumeToBook;
import com.alfredomarino.mybooks.exception.NotFoundGoogleServiceException;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.books.Books;
import com.google.api.services.books.model.Volumes;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchServiceImpl implements SearchService {

    private final Books googleBooksClient;
    private final VolumeToBook volumeToBook;
    private final IsVolumeComplete isVolumeComplete;

    public SearchServiceImpl() throws GeneralSecurityException, IOException {
        googleBooksClient = new Books(GoogleNetHttpTransport.newTrustedTransport(), new JacksonFactory(), null);
        volumeToBook = new VolumeToBook();
        isVolumeComplete = new IsVolumeComplete();
    }

    @Override
    public List<Book> getBooksByName(String name) {
        List<Book> books = new ArrayList<>();
        try {
            Volumes volumes = googleBooksClient.volumes().list(name).execute();
            if (volumes != null && volumes.getItems() != null) {
                books = volumes.getItems().stream().filter(isVolumeComplete).map(volumeToBook).collect(Collectors.toList());
            }
        } catch (IOException e) {
            throw new NotFoundGoogleServiceException("Book not found with google book service", e);
        }
        return books;
    }

    @Override
    public Book getBookByGoogleId(String googleId) {
        Book book;
        try {
            book = volumeToBook.apply(googleBooksClient.volumes().get(googleId).execute());
        } catch (IOException e) {
            throw new NotFoundGoogleServiceException("Book not found with google book service", e);
        }
        return book;
    }
}

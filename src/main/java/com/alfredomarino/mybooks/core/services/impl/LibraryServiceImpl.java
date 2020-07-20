package com.alfredomarino.mybooks.core.services.impl;

import com.alfredomarino.mybooks.core.model.LibraryId;
import com.alfredomarino.mybooks.core.repository.LibraryRepository;
import com.alfredomarino.mybooks.core.services.BookService;
import com.alfredomarino.mybooks.core.services.LibraryService;
import com.alfredomarino.mybooks.core.services.PersonService;
import com.alfredomarino.mybooks.core.model.Book;
import com.alfredomarino.mybooks.core.model.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryServiceImpl implements LibraryService {

    private final LibraryRepository libraryRepository;
    private final BookService bookService;
    private final PersonService personService;

    @Autowired
    public LibraryServiceImpl(LibraryRepository libraryRepository, BookService bookService, PersonService personService) {
        this.libraryRepository = libraryRepository;
        this.bookService = bookService;
        this.personService = personService;
    }

    @Override
    public Library createLibrary(Long personId, String googleId, Library library) {
        library.setPerson(this.personService.getPersonById(personId));
        library.setBook(this.getOrCreateBook(googleId));
        return this.libraryRepository.save(library);
    }

    @Override
    public List<Library> getLibrariesByPersonId(Long personId) {
        return this.libraryRepository.findByPersonPersonId(personId);
    }

    @Override
    public List<Book> getBooksByPersonId(Long personId) {
        List<Library> libraries = this.getLibrariesByPersonId(personId);
        return libraries.stream().map(Library::getBook).collect(Collectors.toList());
    }

    @Override
    public void deleteLibrary(Long personId, Long bookId) {
        this.libraryRepository.deleteById(new LibraryId(personId, bookId));

        if (this.libraryRepository.findByBookBookId(bookId).isEmpty()) {
            this.bookService.deleteBook(bookId);
        }
    }

    private Book getOrCreateBook(String googleId) {
        Book book = this.bookService.getBookByGoogleId(googleId);
        if (book == null) {
            book = this.bookService.createBook(googleId);
        }
        if (book == null) {
            throw new RuntimeException("The book could not be found or created");
        }
        return book;
    }
}

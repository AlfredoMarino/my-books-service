package com.alfredomarino.mybooks.core.services.impl;

import com.alfredomarino.mybooks.core.model.Person;
import com.alfredomarino.mybooks.core.repository.LibraryRepository;
import com.alfredomarino.mybooks.core.services.BookService;
import com.alfredomarino.mybooks.core.services.LibraryService;
import com.alfredomarino.mybooks.core.services.PersonService;
import com.alfredomarino.mybooks.core.services.SearchService;
import com.alfredomarino.mybooks.core.model.Book;
import com.alfredomarino.mybooks.core.model.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    private LibraryRepository libraryRepository;
    private SearchService searchService;
    private BookService bookService;
    private PersonService personService;

    @Autowired
    public LibraryServiceImpl(LibraryRepository libraryRepository, SearchService searchService, BookService bookService, PersonService personService) {
        this.libraryRepository = libraryRepository;
        this.searchService = searchService;
        this.bookService = bookService;
        this.personService = personService;
    }

    @Override
    public Library create(Long personId, String googleId, Library library) {
        System.out.println(library);

        Person person = this.personService.findById(personId);

        Book newBook = this.bookService.getOrCreateBookIfNotExist(googleId);
        if (newBook == null) {
            throw new RuntimeException("The book could not be found or created");
        }

        library.setPerson(person);
        library.setBook(newBook);

        return this.libraryRepository.save(library);
    }

    @Override
    public List<Library> findByPersonId(Long personId) {
        return this.libraryRepository.findByPersonIdPerson(personId);
    }
}

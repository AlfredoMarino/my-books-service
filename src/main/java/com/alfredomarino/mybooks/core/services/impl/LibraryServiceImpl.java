package com.alfredomarino.mybooks.core.services.impl;

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
    public Library create(Library library) throws Exception {
        System.out.println(library);
        if (!this.personService.existsById(library.getPerson().getIdPerson())) {
            throw new Exception("The person does not exist");
        }

        Book newBook = this.bookService.getBookOrCreateIfNotExist(library.getBook());
        if (newBook == null) {
            throw new Exception("The book could not be found or created");
        }

        library.setBook(newBook);

        return this.libraryRepository.save(library);
    }

    @Override
    public List<Library> findByPersonId(int idPerson) {
        //return this.libraryRepository.findLibraryByIdPerson(idPerson);
        return this.libraryRepository.findAll();
    }
}

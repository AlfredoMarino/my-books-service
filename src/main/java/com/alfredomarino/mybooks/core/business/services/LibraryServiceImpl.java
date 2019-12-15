package com.alfredomarino.mybooks.core.business.services;

import com.alfredomarino.mybooks.core.business.repository.LibraryRepository;
import com.alfredomarino.mybooks.core.model.Book;
import com.alfredomarino.mybooks.core.model.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceImpl implements LibraryService{

    private LibraryRepository libraryRepository;
    private SearchService searchService;
    private BookService bookService;

    @Autowired
    public LibraryServiceImpl(LibraryRepository libraryRepository, SearchService searchService, BookService bookService) {
        this.libraryRepository = libraryRepository;
        this.searchService = searchService;
        this.bookService = bookService;
    }

    @Override
    public Library create(Library library) {

        System.out.println(library);
        library.setBook(getBook(library.getBook()));

        return this.libraryRepository.save(library);
    }

    private Book getBook(Book book) {
        Book newBook = null;

        if (book.getIdGoogle() != null){
            //TODO hacer comprobacion si existe ya el google id (hacerlo en el book service)
            newBook = bookService.create(searchService.getBookByGoogleId(book.getIdGoogle()));
        }
        return newBook;
    }
}

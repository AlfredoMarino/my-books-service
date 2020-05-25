package com.alfredomarino.mybooks.core.model;

import java.io.Serializable;
import java.util.Objects;
//TODO REVISAR SI ESTO ES NECESARIO
public class LibraryId implements Serializable {

    private Long person;
    private Long book;

    public LibraryId() {
    }

    public LibraryId(Long person, Long book) {
        this.person = person;
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryId libraryId = (LibraryId) o;
        return Objects.equals(person, libraryId.person) &&
                Objects.equals(book, libraryId.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, book);
    }
}

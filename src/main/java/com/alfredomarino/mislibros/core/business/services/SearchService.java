package com.alfredomarino.mislibros.core.business.services;

import com.alfredomarino.mislibros.core.model.Libro;

import java.util.List;

public interface SearchService {
    public List<Libro> getBooksByName(String name) throws Exception;
}

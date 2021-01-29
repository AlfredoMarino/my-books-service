package com.alfredomarino.mybooks.core.services.impl;

import com.alfredomarino.mybooks.core.repository.CategoryRepository;
import com.alfredomarino.mybooks.core.services.CategoryService;
import com.alfredomarino.mybooks.core.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getCategoryByName(String name) {
        return this.categoryRepository.findByName(name);
    }
}

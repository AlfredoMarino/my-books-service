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
    public Category createCategoryIfNotExist(Category category) {
        Category savedCategory;

        if (category.getName() == null) {
            // TODO manejo de erroes
            System.out.println("Category invalid");
            return null;
        } else {
            savedCategory = this.categoryRepository.findByName(category.getName());
        }
        return (savedCategory != null) ? savedCategory : this.categoryRepository.save(category);
    }
}

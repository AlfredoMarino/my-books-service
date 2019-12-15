package com.alfredomarino.mybooks.core.business.services;

import com.alfredomarino.mybooks.core.business.repository.CategoryRepository;
import com.alfredomarino.mybooks.core.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createIfNotExist(Category category) {
        Category savedCategory = null;

        if (category.getEnglishName() == null && category.getName() == null) {
            // TODO manejo de erroes
            System.out.println("Category invalid");
            return null;
        }
        if (category.getEnglishName() != null) {
            savedCategory = this.categoryRepository.findByEnglishName(category.getEnglishName());
        }
        if (savedCategory == null && category.getName() != null) {
            savedCategory = this.categoryRepository.findByName(category.getName());
        }
        return (savedCategory != null) ? savedCategory : this.categoryRepository.save(category);
    }
}

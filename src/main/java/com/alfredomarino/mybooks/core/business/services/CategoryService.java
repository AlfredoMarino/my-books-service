package com.alfredomarino.mybooks.core.business.services;

import com.alfredomarino.mybooks.core.model.Category;

public interface CategoryService {

    Category createIfNotExist(Category category);
}

package com.alfredomarino.mybooks.core.business.repository;

import com.alfredomarino.mybooks.core.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByEnglishName(String englishName);

    Category findByName(String name);
}

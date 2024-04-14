package com.example.learningspring.repositories;

import com.example.learningspring.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Override
    Category save(Category category);
}

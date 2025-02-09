package com.example.service;
import com.example.model.Category;
import com.example.repository.CategoryRepository;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class CategoryService {
    @Inject
    private CategoryRepository categoryrepository;
public Category saveCategory(Category category){
    return categoryrepository.save(category);
}
public Iterable<Category> getAllCategories(){
    return categoryrepository.findAll();
}

}


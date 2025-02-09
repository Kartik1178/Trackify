package com.example.controller;

import com.example.model.Category;
import com.example.repository.CategoryRepository;
import com.example.service.CategoryService;

import com.example.service.CategoryTypeService;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;



@Controller("/categories")
public class CategoryController {
    @Inject
    private CategoryService categoryservice;
    @Inject
    private CategoryTypeService categoryTypeService;
    @Inject
    private CategoryRepository categoryRepository;
    @Post("/")
    public Category saveCategory(@Body Category category){
        return categoryservice.saveCategory(category);
    }
    @Get("/")
    public Iterable<Category> fetchCategories(){
        return categoryservice.getAllCategories();
    }
    @Get("/{id}")
    public Category findCategory(@PathVariable Long id){
        return categoryTypeService.findCategory(id);
    }

    @Get("/findbyid/{id}")
    public Category findCategoryByid(@PathVariable Long id){return categoryRepository.findById(id).orElseThrow(()->
            new RuntimeException("Category not found"));}
}

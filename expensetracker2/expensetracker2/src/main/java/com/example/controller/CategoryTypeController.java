package com.example.controller;


import com.example.model.Category;
import com.example.model.CategoryType;
import com.example.repository.CategoryTypeRepository;
import com.example.service.CategoryService;
import com.example.service.CategoryTypeService;
import io.micronaut.http.annotation.*;
import io.micronaut.http.server.cors.CrossOrigin;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Map;

@Controller("/categorytype")

public class CategoryTypeController {
    @Inject
    CategoryTypeService categoryTypeService;
    @Inject
    private CategoryTypeRepository categoryTypeRepository;

    @Get("/")
    public List<CategoryType> getAllCategoryTypes() {
        return categoryTypeRepository.findAll();
    }

    @Get("/{category_id}")
    public List<CategoryType> GetCategoryTypesByCategoryId(@PathVariable Long category_id) {
        return categoryTypeService.getCategoryTypesByCategory(category_id);
    }

    @Post("/{category_id}")
    public CategoryType saveCategoryType(@Body Map<String, String> requestBody, @PathVariable Long category_id) {
        String categoryName = requestBody.get("name");
        return categoryTypeService.createCategoryType(categoryName, category_id);
    }

}
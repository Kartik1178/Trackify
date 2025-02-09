package com.example.service;


import com.example.model.Category;
import com.example.model.CategoryType;
import com.example.repository.CategoryRepository;
import com.example.repository.CategoryTypeRepository;
import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Optional;

@Singleton
public class CategoryTypeService {
    @Inject
    CategoryTypeRepository categoryTypeRepository;
    @Inject
    CategoryRepository categoryRepository;

public List<CategoryType> getCategoryTypesByCategory(Long category_id){
    return categoryTypeRepository.findByCategory_Id(category_id);

}
public Category findCategory(Long id){
    Optional<CategoryType> categoryType=categoryTypeRepository.findById(id);
    if(categoryType.isPresent()){
      return categoryType.get().getCategory();
    }
    else{
       throw new RuntimeException("Category type not found");
    }
}
public CategoryType createCategoryType(String categoryName,Long category_id){
  Category category=categoryRepository.findById(category_id).orElseThrow(()->new RuntimeException("Category not found"));

    CategoryType categoryType=new CategoryType(categoryName,category);
    return categoryTypeRepository.save(categoryType);
}

}

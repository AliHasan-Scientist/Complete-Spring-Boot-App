package com.backend.myappbackend.services;

import com.backend.myappbackend.models.Category;
import com.backend.myappbackend.payload.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CategoryService {
    // add Category
     CategoryDto createCategory(CategoryDto categoryDto);

    //Get  All Categories
     List<CategoryDto> getAllCategory();

    // Get one Category
     CategoryDto getCategoryById(Integer id);

    //update Category
     CategoryDto updateCategory(CategoryDto categoryDto, Integer id);

    //delete Category
     void deleteCategory(Integer id);

}

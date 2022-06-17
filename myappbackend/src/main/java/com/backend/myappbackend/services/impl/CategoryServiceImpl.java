package com.backend.myappbackend.services.impl;

import com.backend.myappbackend.exceptions.ResourceNotFoundException;
import com.backend.myappbackend.models.Category;
import com.backend.myappbackend.payload.CategoryDto;
import com.backend.myappbackend.repo.CategoryRepository;
import com.backend.myappbackend.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = this.dtoToCategory(categoryDto);
        Category savedCategory = this.categoryRepository.save(category);
        return this.categoryToDto(savedCategory);

    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> category = (List<Category>) this.categoryRepository.findAll();
        List<CategoryDto> categoryDtos = category.stream().map(catego -> this.categoryToDto(catego)).collect(Collectors.toList());
        return categoryDtos;
    }

    @Override
    public CategoryDto getCategoryById(Integer id) {

        Category category = this.categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("UserName", "userId", id));


        return this.categoryToDto(category);

    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer id) {
        Category category = this.categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "userId", id));
        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(categoryDto.getCategoryDescription());
        Category category1 = this.categoryRepository.save(category);
        CategoryDto categoryToDto = this.categoryToDto(category);
        return categoryToDto;

    }

    @Override
    public void deleteCategory(Integer id) {
        Category category = this.categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "userId", id));
        this.categoryRepository.delete(category);
    }

    //Model Mapper
    public Category dtoToCategory(CategoryDto categoryDto) {
        Category category = this.modelMapper.map(categoryDto, Category.class);
        return category;
    }

    public CategoryDto categoryToDto(Category category) {
        CategoryDto categoryDto = this.modelMapper.map(category, CategoryDto.class);
        return categoryDto;
    }
}

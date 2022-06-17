package com.backend.myappbackend.controllers;

import com.backend.myappbackend.payload.ApiReseponse;
import com.backend.myappbackend.payload.CategoryDto;
import com.backend.myappbackend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    // Create a new Category
    @PostMapping("/create")
    public ResponseEntity<CategoryDto> createUser(@Valid @RequestBody CategoryDto categoryDto) {
        CategoryDto addCategory = this.categoryService.createCategory(categoryDto);
        return (new ResponseEntity<>(addCategory, HttpStatus.CREATED));
    }

    // Read a Category
    @GetMapping("/getCategory")
    public ResponseEntity<List<CategoryDto>> getAllCategory() {

        return (ResponseEntity.ok(categoryService.getAllCategory()));
    }

    // Read a Category ById
    @GetMapping(value = "/getCategory/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer categoryId) {
        CategoryDto categoryDto = categoryService.getCategoryById(categoryId);
        return ResponseEntity.ok(categoryDto);
    }

    //Update a Category
    @PutMapping("/update/{categoryId}")
    public ResponseEntity<CategoryDto> updateUser(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId) {
        CategoryDto updateCategory = this.categoryService.updateCategory(categoryDto, categoryId);
        return ResponseEntity.ok(updateCategory);
    }

    // Delete Category
    @DeleteMapping("/deleteCategory/{categoryId}")
    public ResponseEntity<ApiReseponse> deleteUser(@PathVariable Integer categoryId) {
        this.categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(new ApiReseponse("user Deleted Successfully", true), HttpStatus.ACCEPTED);
    }


}


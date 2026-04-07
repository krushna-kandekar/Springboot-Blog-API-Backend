package com.example.blog.services;

import java.util.List;

import com.example.blog.payloads.CategoryDto;

public interface CategoryService {
	
	//create
	
	CategoryDto createCategoryDto(CategoryDto categoryDto);
	
	//update
	
	CategoryDto updateCategoryDto(CategoryDto categoryDto,Integer categoryId);
	
	//delete
	
	void deleteCategory(Integer categoryId);
	
	//get
	
	CategoryDto getCategory(Integer categoryId);
	
	//get All
	
	List<CategoryDto> getCategories();

}

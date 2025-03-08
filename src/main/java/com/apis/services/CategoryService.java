package com.apis.services;

import java.util.List;

import com.apis.payloads.CategoryDto;

public interface CategoryService {
	//create
	CategoryDto creteCategory(CategoryDto categoryDto);
	
	
	//update
	CategoryDto updateCategory(CategoryDto categoryDto , Integer categoryId);
	
	//delete
	void deleteCategory(Integer categeryId);
	
	//get
	CategoryDto getCategeryByid(Integer categoryId);
	
	
	//gelAll
	List<CategoryDto> getcategores();

}

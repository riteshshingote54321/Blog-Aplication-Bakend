package com.apis.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apis.entites.Categary;
import com.apis.exceptions.ResourceNotFoundException;
import com.apis.payloads.CategoryDto;
import com.apis.repositarys.categoryRepo;
import com.apis.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private categoryRepo repo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto creteCategory(CategoryDto categoryDto) {
	Categary cat	=this.modelMapper.map(categoryDto, Categary.class);
	Categary addcat= this.repo.save(cat);
	return this.modelMapper.map(addcat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
	Categary cat	=this.repo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Category id", categoryId));
	cat.setCategoryTitle(categoryDto.getCategoryTitle());
	cat.setCategoryDescription(categoryDto.getCategoryDescription());
	Categary updatedcat= this.repo.save(cat);
	return this.modelMapper.map(updatedcat, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categeryId) {
		Categary cat = this.repo.findById(categeryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Category id", categeryId));
		this.repo.delete(cat);

	}

	@Override
	public CategoryDto getCategeryByid(Integer categoryId) {
		Categary categary=this.repo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Category id", categoryId));
		return this.modelMapper.map(categary, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getcategores() {
		List<Categary> categorys=this.repo.findAll();
		List<CategoryDto> categoryDtos=categorys.stream().map((cat)-> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		
		return categoryDtos;
	}
	
	
	

}

package com.apis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apis.payloads.ApiResponce;
import com.apis.payloads.CategoryDto;
import com.apis.payloads.UserDto;
import com.apis.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	//create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createUser(@Valid @RequestBody CategoryDto categoryDto)
	{
		CategoryDto creteDto=this.categoryService.creteCategory(categoryDto);
		return new ResponseEntity<>(creteDto , HttpStatus.CREATED);
	}
	
	//update
	@PutMapping("/{CategoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto , @PathVariable("CategoryId") Integer cid)
	{
		CategoryDto updatedcategory=this.categoryService.updateCategory(categoryDto, cid);
		return ResponseEntity.ok(updatedcategory);
	}
	
	
	//delete
	@DeleteMapping("/{CategoryId}")
	public ResponseEntity<ApiResponce> deleteCategory(@PathVariable("CategoryId") Integer cId) {
		this.categoryService.deleteCategory(cId);
		
		return new ResponseEntity<ApiResponce>(new ApiResponce("user deleted successfully" , true), HttpStatus.OK);
	}
	
	//getbyid
	@GetMapping("/{CategoryId}")
	public ResponseEntity<CategoryDto> getById( @PathVariable("CategoryId") Integer cId)
	{
		return ResponseEntity.ok(this.categoryService.getCategeryByid(cId));
	}
	
	
	//getalluser
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAll(){
	
		return ResponseEntity.ok(this.categoryService.getcategores());
	}
	
	
	
	

}

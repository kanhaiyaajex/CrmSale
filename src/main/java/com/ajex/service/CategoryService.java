package com.ajex.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ajex.dto.CategoryDto;
import com.ajex.entity.Category;
import com.ajex.exception.ResourceNotFoundException;

public interface CategoryService {
	
	public CategoryDto addCategory(Category Category);
	
	public ResponseEntity<?> updateCategory(Integer id,Category Category) throws ResourceNotFoundException ;

	
	public void deleteCategory(Integer id);
	
	
	public List<Category> getAllCategories();


     	

	


}

package com.ajex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajex.dto.CategoryDto;
import com.ajex.entity.Category;
import com.ajex.exception.ResourceNotFoundException;
import com.ajex.repository.CategoryRepo;
import com.ajex.service.CategoryService;


@RestController

@RequestMapping("/api/v1/category/")
public class CategoryController {
	

	
	@Autowired
	private CategoryService  CategoryService;
	

	@Autowired
	private CategoryRepo  CategoryRepo;
	
	@GetMapping("/getCategories")
	public  ResponseEntity<?>  getAllCategory()
	{
		Map<Object,Object> m = new HashMap<>();

		try {
			List<Category>  allCities= CategoryService.getAllCategories();
			
             m.put("data",allCities );
			
			m.put("status","OK" );

			m.put("statusCode","200" );
			m.put("boolean","success");

			return new ResponseEntity<>(m, HttpStatus.OK);
			
		}catch (Exception e) {
			
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		
	}
	


	
	
	
	
	@PostMapping("/addCategory")
	public ResponseEntity<?> addCategory(@Validated @RequestBody Category Category) throws ResourceNotFoundException{
		
		Map<Object,Object> m = new HashMap<>();

			  CategoryDto  CategoryVal= CategoryService.addCategory(Category);
			  try {
				
	             m.put("data",CategoryVal );
				
				m.put("status","OK" );

				m.put("statusCode","201" );
				m.put("boolean","success");

				return new ResponseEntity<>(m, HttpStatus.OK);
				
			}catch (Exception e) {
				
				return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
			}
			
			  
			
		
	}
	
	
	@PostMapping("/updateCategory/{id}")
	
		public ResponseEntity<?> updateCategory(@Validated @PathVariable("id") Integer id, @RequestBody Category Category) throws ResourceNotFoundException  {
			
		 
	    ResponseEntity<?>  CategoryUpdated = CategoryService.updateCategory(id,Category);
		
		return new ResponseEntity<>(CategoryUpdated, HttpStatus.CREATED);
		
		
	}
	
	
	@PostMapping("/deleteCategory/{id}")
	public Map<String,Object> deleteCategory(@PathVariable Integer id)
	{
		Map<String,Object> m=new HashMap<>();
		
		try {
		   CategoryService.deleteCategory(id);
		    m.put("boolean", "success");
			m.put("message", "Category is deleted successfully");
		}
		
		catch (Exception e) {
			m.put("boolean", "false");
			m.put("message", "Category does not exist");
		}
			
		
		
		
		 return m;
		 
		 
		
	}
	

}

package com.ajex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajex.dto.ProductDto;
import com.ajex.entity.Product;
import com.ajex.repository.ProductRepo;
import com.ajex.service.ProductService;

@RestController
@RequestMapping("/api/v1/product/")
public class ProductController {

	
	
	@Autowired
	private ProductService  ProductService;
	

	@Autowired
	private ProductRepo  ProductRepo;
	
	
	@GetMapping("/getCities")
	public List<Product>  getAllProduct()
	{
		
		List<Product>  allCities= ProductService.getAllProduct();
		return allCities;
		
	}
	
	
	@PostMapping("/addProduct")
	public ProductDto  addProduct(@RequestBody   Product Product)
	{
		
		ProductDto  ProductVal= ProductService.addProduct(Product);
		return ProductVal;
		
	}
	
	
	
	@PostMapping("/updateProduct/{id}")
	
		public ProductDto updateProduct(@PathVariable("id") String id, @RequestBody Product Product) {
			
				  
				  return  ProductService.updateProduct(id, Product);
				  
			  
			 
	}
	
	
	@PostMapping("/deleteProduct/{id}")
	public Map<String,Object> deleteProduct(@PathVariable String id)
	{
		Map<String,Object> m=new HashMap<>();
		
		try {
		   ProductService.deleteProduct(id);
		    m.put("boolean", "success");
			m.put("message", "Product is deleted successfully");
		}
		
		catch (Exception e) {
			m.put("boolean", "false");
			m.put("message", "Product does not exist");
		}
			
		
		
		
		 return m;
		 
		 
		
	}
	
	
	
	
}


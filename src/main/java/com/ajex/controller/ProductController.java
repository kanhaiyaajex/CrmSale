package com.ajex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	public  ResponseEntity<?>  getAllProduct()
	{
		
		List<Product>  allCities= ProductService.getAllProduct();
Map<Object,Object> m = new HashMap<>();

		
		
		

		
        m.put("data",allCities );
		
		m.put("status","OK" );

		m.put("statusCode","200" );
		m.put("boolean","success");
		
		 return new ResponseEntity<>(m, HttpStatus.OK);      
		
	}
	
	
	@PostMapping("/addProduct")
	public ProductDto  addProduct(@RequestBody   Product Product)
	{
		
		ProductDto  ProductVal= ProductService.addProduct(Product);
		return ProductVal;
		
	}
	
	
	
	@PostMapping("/updateProduct/{id}")
	
		public ProductDto updateProduct(@PathVariable("id") Integer id, @RequestBody Product Product) {
			
				  
				  return  ProductService.updateProduct(id, Product);
				  
			  
			 
	}
	
	
	@PostMapping("/deleteProduct/{id}")
	public Map<String,Object> deleteProduct(@PathVariable Integer id)
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


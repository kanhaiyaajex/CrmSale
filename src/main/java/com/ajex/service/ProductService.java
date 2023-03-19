package com.ajex.service;

import java.util.List;

import com.ajex.dto.ProductDto;
import com.ajex.entity.Product;

public interface ProductService {
	
	public ProductDto addProduct(Product Product);
	
	public ProductDto updateProduct(String id,Product Product);

	
	public void deleteProduct(String id);
	
	
	public List<Product> getAllProduct();

     	

	


}

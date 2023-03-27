package com.ajex.service;

import java.util.List;

import com.ajex.dto.ProductDto;
import com.ajex.entity.Product;

public interface ProductService {
	
	public ProductDto addProduct(Product Product);
	
	public ProductDto updateProduct(Integer id,Product Product);

	
	public void deleteProduct(Integer id);
	
	
	public List<Product> getAllProduct();

     	

	


}

package com.ajex.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ajex.dto.ProductDto;
import com.ajex.entity.Product;
import com.ajex.repository.ProductRepo;
import com.ajex.service.ProductService;



@Service
public class ProductServiceImpl implements ProductService {



@Autowired
private ProductRepo  ProductRepo;


	@Override
	public ProductDto addProduct(Product Product) {
  
		
		Product ProductValue=ProductRepo.save(Product);
		ProductDto ProductDto = new ModelMapper().map(ProductValue, ProductDto.class);

		return ProductDto;
	}

	@Override
	public ProductDto updateProduct(String id,Product Product) {

		ProductDto ProductDto=null;
		Optional<Product> ProductData = ProductRepo.findById(id);

		  if (ProductData.isPresent()) {
		    Product ProductVal = new Product();
		    ProductVal.setProductId(id);
//		    ProductVal.setProductNameInAr(Product.getProductNameInAr());
//		    ProductVal.setProductCode(Product.getProductCode());
//		    ProductVal.setCountryId(Product.getCountryId());
//		    ProductVal.setRegionId(Product.getRegionId());
//		    ProductVal.setStatusId(Product.isStatusId());
		    
		    ProductRepo.save(Product);
			ProductDto = new ModelMapper().map(ProductRepo.save(Product), ProductDto.class);

		  }
		  return ProductDto;	}



	@Override
	public void deleteProduct(String id) {

		Product ProductValue= ProductRepo.findById(id).get();
		
		if(ProductValue!=null)
		{
			ProductRepo.delete(ProductValue);
			
		}
	}

	@Override
	public List<Product> getAllProduct() {
		
      List<Product> ProductValue= ProductRepo.findAll();

		
		if(!ProductValue.isEmpty())
				
		{
			return ProductValue;
		}
		return ProductValue;
	}

}

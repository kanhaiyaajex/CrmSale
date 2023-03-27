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
import static com.ajex.entity.Product.*;



@Service
public class ProductServiceImpl implements ProductService {



@Autowired
private com.ajex.entity.SequenceGeneratorService service;



@Autowired
private ProductRepo  ProductRepo;


	@Override
	public ProductDto addProduct(Product product) {
  
		product.setProductId(service.getSequenceNumber(SEQUENCE_NAME));
		Product ProductValue=ProductRepo.save(product);
		ProductDto ProductDto = new ModelMapper().map(ProductValue, ProductDto.class);

		return ProductDto;
	}

	@Override
	public ProductDto updateProduct(Integer id,Product product) {

		ProductDto ProductDto=null;
		Optional<Product> ProductData = ProductRepo.findById(id);

		  if (ProductData.isPresent()) {
		    Product ProductVal = new Product();
		    ProductVal.setProductId(id);
		    ProductVal.setNameInAr(product.getNameInAr());
		    ProductVal.setDivisionId(product.getDivisionId());
		    ProductVal.setStatusId(product.isStatusId());
		    
		    ProductRepo.save(product);
			ProductDto = new ModelMapper().map(ProductRepo.save(product), ProductDto.class);

		  }
		  return ProductDto;	}



	@Override
	public void deleteProduct(Integer id) {

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

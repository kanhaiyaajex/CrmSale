package com.ajex.dto;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class ProductDto {
	
	
	
	
	@Id
	private String productId;
	
	
	private String nameInAr;
	
	private String division;
	
	private boolean statusId;
	
	

}

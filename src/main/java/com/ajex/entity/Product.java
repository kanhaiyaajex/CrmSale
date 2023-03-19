package com.ajex.entity;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Product {
	
	
	
	
	@Id
	private String productId;
	
	
	private String nameInAr;
	
	private String division;
	
	private boolean statusId;
	
	

}

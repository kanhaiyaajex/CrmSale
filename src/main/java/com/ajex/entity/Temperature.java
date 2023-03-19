package com.ajex.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Temperature {
	
	
	
	@Id
	
	private String temperatureId;
	
	private String name;
	
	private String subProductId;

	
	private boolean statusId;

	
	private String divisionName;

	
	
	
	

}

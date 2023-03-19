package com.ajex.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;



@Data
@Document(collection = "employee")
public class Employee {
	
	
	
	@Id
	private String empId;
	
	
	private String name;
	private String countryId;
	
	private String regionId;
	
	
	private String position;
	
	private boolean statusId;

}

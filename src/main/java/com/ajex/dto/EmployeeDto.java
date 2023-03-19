package com.ajex.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;



@Data
public class EmployeeDto {
	
	
	
	
	private String empId;
	
	
	private String name;
	private String countryId;
	
	private String regionId;
	
	
	private String position;
	
	private boolean statusId;

}

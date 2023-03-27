package com.ajex.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import lombok.Data;



@Data
@Document(collection = "employee")
public class Employee {
	

    @Transient
    public static final String SEQUENCE_NAME = "emp_sequence";
	
	@Id
	private Integer empId;
	
    @NotNull(message = "Name   is mandatory")

	private String name;
    
    @NotNull(message = "Country Id  is mandatory")

	private Country countryId;
	
    
    @NotNull(message = "Region Id  is mandatory")

	private Region regionId;
	
    
    @NotNull(message = "City Id  is mandatory")

	private City cityId;

    
    @NotNull(message = "Position Id  is mandatory")

	private Position positionId;
    
    

    @NotNull(message = "Division Id  is mandatory")

	private Division divisionId;
    
    
	
    private boolean  statusId=true;

}

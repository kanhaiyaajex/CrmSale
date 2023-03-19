package com.ajex.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor

public class PortCitiesDto {
	
	
	private String portId;
	
	private String portCitName;
	
	private String portType;
	
	private Integer cityId;;

	
	private Integer countryId;

	
	private String referenceId;

	
	private boolean statusId;


	

}

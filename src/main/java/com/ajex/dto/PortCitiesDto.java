package com.ajex.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ajex.entity.City;
import com.ajex.entity.Country;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor

public class PortCitiesDto {
	
	
    private Integer portId;
	
	private String portCityName;
	
	private String portType;
	
	private City cityId;;

	
	private Country countryId;

	
	private Integer refId;

	
	private boolean statusId;


	

}

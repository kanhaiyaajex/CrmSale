package com.ajex.dto;

import com.ajex.entity.City;
import com.ajex.entity.Country;
import com.ajex.entity.Position;
import com.ajex.entity.Region;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	
	
private Integer empId;
	
	
	private String name;
	private Country countryId;
	
	private Region regionId;
	
	private City cityId;

	private Position positionId;
	
	private boolean statusId;


}

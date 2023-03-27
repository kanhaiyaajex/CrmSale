package com.ajex.dto;

import java.util.List;

import com.ajex.entity.City;
import com.ajex.entity.Region;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CountryRegionCityDto {
	
	
	private Integer countryId;
	
	private String countryName;
	
	private Region[] region;
	
	private City[]  city;
	
	private String   statusCode;
	private String   status;

}

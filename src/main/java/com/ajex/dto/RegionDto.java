package com.ajex.dto;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ajex.entity.City;
import com.ajex.entity.Country;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegionDto {
	
	
private Integer regionId;
	
	
    @NotNull(message = "CountryId  is mandatory")

	private Country countryId;
	
    @NotNull(message = "Region name  is mandatory")

	private String regionName;
    
	private String regionCode;

   
    private List<City> city;
    
    @NotNull(message = "RefId   is mandatory")

	private Integer refId;

	
	private boolean statusId;

	
	

}

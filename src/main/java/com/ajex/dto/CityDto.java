package com.ajex.dto;

import org.springframework.data.annotation.Id;

import com.ajex.entity.CityGroup;
import com.ajex.entity.Country;
import com.ajex.entity.Region;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CityDto {
	
	
	private Integer cityId;
	
	
    @NotNull(message = "City Name  is mandatory")

	private String cityNameInAr;
	
    
    @NotNull(message = "City code  is mandatory")

	private String cityCode;


    
	private CityGroup cityGroupId;

	
    @NotNull(message = "Region Id  is mandatory")

	private Region regionId;


	private Country countryId;

	private boolean statusId;
	
	private Integer refId;

}



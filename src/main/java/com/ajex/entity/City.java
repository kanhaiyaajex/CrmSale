package com.ajex.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "city")
public class City {
	

    @Transient
    public static final String SEQUENCE_NAME = "city_sequence";
	
	@Id
	private Integer cityId;
	
	
    @NotNull(message = "City Name  is mandatory")

	private String cityNameInAr;
	
    
    @NotNull(message = "City code  is mandatory")

	private String cityCode;



	private CityGroup cityGroupId;

	
    @NotNull(message = "Region Id  is mandatory")

	private Region regionId;

    
//    @NotNull(message = "Country Id  is mandatory")
//
//	private Country countryId;

    private boolean  statusId=true;
	
	private Integer refId;


}

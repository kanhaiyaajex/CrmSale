package com.ajex.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "portCity")

public class PortCities {
	
	

    @Transient
    public static final String SEQUENCE_NAME = "portcity_sequence";
    
    
	@Id
	private Integer portId;
	
	
    @NotNull(message = "Port city name  is mandatory")

	private String portCityName;
	
    @NotNull(message = "Port type  is mandatory")

	private String portType;
	
    @NotNull(message = "City Id  is mandatory")

	private City cityId;;

    @NotNull(message = "Country Id  is mandatory")

	private Country countryId;

	
	private Integer refId;

	
    private boolean  statusId=true;


	

}

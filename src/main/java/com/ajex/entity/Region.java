package com.ajex.entity;




import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "region")
public class Region {
	

    @Transient
    public static final String SEQUENCE_NAME = "region_sequence";
    
	
	@Id
	private Integer regionId;
	
	
    @NotNull(message = "CountryId  is mandatory")

	private Country countryId;
	
    @NotNull(message = "Region name  is mandatory")

	private String regionName;
    
    @NotNull(message = "Region code  is mandatory")

	private String regionCode;

   
    private List<City> city;
    

	private Integer refId;

	
	private boolean statusId;
	
	

	
	
	

}

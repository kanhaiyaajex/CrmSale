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
@Document(collection = "country")
public class Country {
	

    @Transient
    public static final String SEQUENCE_NAME = "country_sequence";
	
	
	@Id
	

	private Integer countryId;
	
	
    @NotNull(message = "Country code  is mandatory")

	private String countryCode;
	
      
      private List<Region> region;
		
      @NotNull(message = "Category name  is mandatory")

	private String countryName;
	
	private Integer refId;
	
    private boolean  statusId=true;

}

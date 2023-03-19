package com.ajex.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "region")
public class Region {
	
	
	
	@Id
	private String regionId;
	
	private String countryId;
	
	
	private String regionName;

	
	private String refId;

	
	private boolean statusId;

	
	
	

}

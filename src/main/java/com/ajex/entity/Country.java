package com.ajex.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "country")
public class Country {
	
	
	@Id
	private String countryId;
	
	private String countryCode;
	
	private String countryName;
	
	private String refId;
	
	private boolean statusId;

}

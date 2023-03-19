package com.ajex.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Data
@Document(collection = "city")
public class City {
	
	
	@Id
	private String cityId;
	
	
	private String cityNameInAr;
	
	private String cityCode;

	
	private String regionId;

	private String countryId;

	private boolean statusId;

}

package com.ajex.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;




@Data


@Document(collection = "cityGroup")
public class CityGroup {

	
	@Id
	private String cityGroupId;
	
	private String groupName;
	
	private String groupOrderId;
	
	private boolean statusId;
	
	
	
	
	
}



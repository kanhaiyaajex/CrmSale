package com.ajex.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;




@Data


public class CityGroupDto {

	
	
	private String cityGroupId;
	
	private String groupName;
	
	private String groupOrderId;
	
	private boolean statusId;
	
	
	
	
	
}



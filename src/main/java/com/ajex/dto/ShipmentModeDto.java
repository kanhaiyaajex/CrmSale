package com.ajex.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "shipmentMode")

public class ShipmentModeDto {
	
	
	
	@Id
	private String shipMentModeId;
	
	
	private String name;
	
	private boolean statusId;
	
	
	
	

}

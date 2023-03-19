package com.ajex.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionDto {
	
	
	
	
	private String positionId;
	
	private String positionName;
	
	private String orderId;
	
	private boolean statusId;

}

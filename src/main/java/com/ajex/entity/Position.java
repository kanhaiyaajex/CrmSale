package com.ajex.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "position")
public class Position {
	
	
	
	@Id
	private String positionId;
	
	private String positionName;
	
	private String orderId;
	
	private boolean statusId;

}

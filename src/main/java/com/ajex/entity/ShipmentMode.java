package com.ajex.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "shipmentMode")

public class ShipmentMode {
	
	

    @Transient
    public static final String SEQUENCE_NAME = "shipmentmode_sequence";
    
    
	@Id
	private Integer shipMentModeId;
	
    @NotNull(message = "Shipment name  is mandatory")

	private String name;
	
    private boolean  statusId=true;
	
	
	
	

}

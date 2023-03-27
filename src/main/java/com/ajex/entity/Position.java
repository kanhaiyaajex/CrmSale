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
@Document(collection = "position")
public class Position {
	

    @Transient
    public static final String SEQUENCE_NAME = "position_sequence";
	
	@Id
	private Integer positionId;
	
    @NotNull(message = "Position Name is mandatory")

	private String positionName;
    
    
    @NotNull(message = "Order Id  is mandatory")

    
	private String orderId;
	
    private boolean  statusId=true;

}

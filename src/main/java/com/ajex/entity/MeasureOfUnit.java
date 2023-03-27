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
@Document(collection = "measureOfUnit")
public class MeasureOfUnit {

	
		

	    @Transient
	    public static final String SEQUENCE_NAME = "measureOfUnit_sequence";
		
		
		@Id
	
		private Integer measureOfUnitId;
		
	    @NotNull(message = "Unit name  is mandatory")

		private String unitName;
		
	    private boolean  statusId=true;


}
	


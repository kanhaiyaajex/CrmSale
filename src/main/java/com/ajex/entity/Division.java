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
@Document(collection = "division")
public class Division {


		

	    @Transient
	    public static final String SEQUENCE_NAME = "division_sequence";
		
		
		@Id
	
		private Integer divisionId;
		
	    @NotNull(message = "Division name  is mandatory")

		private String divisionName;
		
	    private boolean  statusId=true;


}

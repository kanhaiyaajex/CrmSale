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
@Document(collection = "category")
public class Category {

	
	 @Transient
	    public static final String SEQUENCE_NAME = "categoty_sequence";
		
		
		@Id
	
		private Integer categoryId;
		
	    @NotNull(message = "Category name  is mandatory")

		private String name;
	    
	    private boolean  statusId=true;
}

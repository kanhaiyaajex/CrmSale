package com.ajex.entity;

import java.util.Locale.Category;

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
@Document(collection = "additionalService")
public class AdditionalService {
	

    @Transient
    public static final String SEQUENCE_NAME = "adService_sequence";
	
	@Id
	private Integer additionalServiceId;
	
	
    @NotNull(message = "Category Id  is mandatory")

	private Category categoryId;
    
    

    @NotNull(message = "DivisionId  is mandatory")

	private Division divisionId;
	
	
    private boolean  statusId=true;
	

	

}

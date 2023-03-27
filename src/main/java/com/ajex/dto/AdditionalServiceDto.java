package com.ajex.dto;

import java.util.Locale.Category;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ajex.entity.Division;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AdditionalServiceDto {
	
	private Integer additionalServiceId;
	
	

	private Category categoryId;
    
    


	private Division divisionId;
	
	
    private boolean  statusId;
	
	

}

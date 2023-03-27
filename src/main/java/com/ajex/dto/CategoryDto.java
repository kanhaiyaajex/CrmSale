package com.ajex.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
	
	private Integer categoryId;
	
    @NotNull(message = "Category name  is mandatory")

	private String name;
    
    private boolean  statusId=true;



}

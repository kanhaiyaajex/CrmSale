package com.ajex.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	

    @Transient
    public static final String SEQUENCE_NAME = "product_sequence";
	
	@Id
	private Integer productId;
	
	
	
    @NotNull(message = "Name is  is mandatory")

	private String nameInAr;
	
	
	private List<SubProduct> subProduct;
	
	
    @NotNull(message = "Division Id  is mandatory")

	private Division divisionId;
	
	private boolean statusId;
	
	@DateTimeFormat(pattern="dd.MM.yyyy hh:mm")
	@CreatedDate
	private LocalDateTime  createdAt;
	
	
	@DateTimeFormat(pattern="dd.MM.yyyy hh:mm")
	@LastModifiedDate
	private LocalDateTime  modifiedAt;
	

}

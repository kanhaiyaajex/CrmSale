package com.ajex.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
@Document(collection="subProduct")
public class SubProduct {
	

	

    @Transient
    public static final String SEQUENCE_NAME = "subproduct_sequence";
    
	@Id
	private Integer subProductId;
	
    @NotNull(message = "Name  is mandatory")

	private String nameInAr;
	
    @NotNull(message = "Division id  is mandatory")

	private Division divisionId;
	
    
    @NotNull(message = "Product id  is mandatory")

	private Product productId;

    @NotNull(message = "MeasureOfUnit id  is mandatory")

	private MeasureOfUnit measureOfUnitId;
	
	
    private boolean  statusId=true;
	
	
	
	@DateTimeFormat(pattern="dd.MM.yyyy hh:mm")
	@CreatedDate
	private LocalDateTime  createdAt;
	
	
	@DateTimeFormat(pattern="dd.MM.yyyy hh:mm")
	@LastModifiedDate
	private LocalDateTime  modifiedAt;
	
	

}

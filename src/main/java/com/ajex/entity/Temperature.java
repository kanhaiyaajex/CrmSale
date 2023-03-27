package com.ajex.entity;

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
@Document
public class Temperature {
	
	

    @Transient
    public static final String SEQUENCE_NAME = "temp_sequence";
    
	@Id
	
	private Integer temperatureId;
	
	
    @NotNull(message = "Name   is mandatory")

	private String name;
	
    @NotNull(message = "SubProduct id  is mandatory")

	private SubProduct subProductId;

	
    private boolean  statusId=true;

	
	
	@DateTimeFormat(pattern="dd.MM.yyyy hh:mm")
	@CreatedDate
	private LocalDateTime  createdAt;
	
	
	@DateTimeFormat(pattern="dd.MM.yyyy hh:mm")
	@LastModifiedDate
	private LocalDateTime  modifiedAt;
	
	
	
	
	

}

package com.ajex.dto;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.ajex.entity.SubProduct;

import lombok.Data;


@Data
public class TemperatureDto {
	
	
	
private Integer temperatureId;
	
	private String name;
	
	private SubProduct subProductId;

	
	private boolean statusId;

	
	
	@DateTimeFormat(pattern="dd.MM.yyyy hh:mm")
	@CreatedDate
	private LocalDateTime  createdAt;
	
	
	@DateTimeFormat(pattern="dd.MM.yyyy hh:mm")
	@LastModifiedDate
	private LocalDateTime  modifiedAt;
	
	
	
	
	

}

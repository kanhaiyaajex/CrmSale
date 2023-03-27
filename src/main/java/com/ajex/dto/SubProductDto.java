package com.ajex.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.ajex.entity.Division;
import com.ajex.entity.MeasureOfUnit;
import com.ajex.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubProductDto {
	
	private Integer subProductId;
	
	
	private String nameInAr;
	
	private Division divisionId;
	
	private Product productId;

	private MeasureOfUnit measureOfUnit;
	
	
	private boolean statusId;
	
	
	private Integer measureOfUnitId;
	
	@DateTimeFormat(pattern="dd.MM.yyyy hh:mm")
	@CreatedDate
	private LocalDateTime  createdAt;
	
	
	@DateTimeFormat(pattern="dd.MM.yyyy hh:mm")
	@LastModifiedDate
	private LocalDateTime  modifiedAt;
	

}

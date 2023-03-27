package com.ajex.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.ajex.entity.City;
import com.ajex.entity.Division;
import com.ajex.entity.Product;
import com.ajex.entity.SubProduct;
import com.ajex.entity.Temperature;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RateCardDto {
	
	
	
	private Integer rateCardId;

	private SubProduct subProductId;

	private Product productId;

	
	
	private Temperature temperatureId;

	private City originCityId;

	private City destinationCityId;
	
	private Division  division;


	private BigDecimal basePrice;
	
	
	
	private boolean statusId;
	
	@DateTimeFormat(pattern="dd.MM.yyyy hh:mm")
	@CreatedDate
	private LocalDateTime  createdAt;
	
	
	@DateTimeFormat(pattern="dd.MM.yyyy hh:mm")
	@LastModifiedDate
	private LocalDateTime  modifiedAt;
	
	

	

}

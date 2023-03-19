package com.ajex.dto;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "portCity")
public class RateCardDto {
	
	
	@Id
	private String rateCardId;
	private String productId;

	private String subProductId;

	private String temperatureId;

	private String originCityId;

	private String destinationCityId;

	private BigDecimal basePrice;
	
	private boolean statusId;
	
	private Date createdDate;
	private Date updatedDate;

	
	private String divisionId;
	
	

	

}

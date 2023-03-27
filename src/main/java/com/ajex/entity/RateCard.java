package com.ajex.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "rateCard")
public class RateCard {
	

    @Transient
    public static final String SEQUENCE_NAME = "ratecard_sequence";
    
    
	@Id
	private Integer rateCardId;

	
    @NotNull(message = "SubProduct Id  is mandatory")

	private SubProduct subProductId;

    
    @NotNull(message = "Product Id  is mandatory")

	private Product productId;

	
    @NotNull(message = "Temperature Id  is mandatory")

	private Temperature temperatureId;
    
    
    @NotNull(message = "OriginCity Id   is mandatory")

	private City originCityId;

    @NotNull(message = "Destination City Id  is mandatory")

	private City destinationCityId;
	
    @NotNull(message = "Division  Id  is mandatory")

	private Division  division;

    @NotNull(message = "Base Price   is mandatory")

	private BigDecimal basePrice;
	
	
	
	private boolean statusId;
	
	@DateTimeFormat(pattern="dd.MM.yyyy hh:mm")
	@CreatedDate
	private LocalDateTime  createdAt;
	
	
	@DateTimeFormat(pattern="dd.MM.yyyy hh:mm")
	@LastModifiedDate
	private LocalDateTime  modifiedAt;
	

	
	
	

	

}

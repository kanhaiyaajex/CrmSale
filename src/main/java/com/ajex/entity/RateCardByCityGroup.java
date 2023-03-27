package com.ajex.entity;

import java.math.BigDecimal;
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


@Document(collection = "RateCardBycityGroup")
public class RateCardByCityGroup {



    @Transient
    public static final String SEQUENCE_NAME = "rateCardByCityGroup_sequence";
	
	@Id
	private Integer rateCardByCityGroupId;
	
    @NotNull(message = "Group name  is mandatory")

	private String groupName;
	
    @NotNull(message = "Group order id  is mandatory")

	private String groupOrderId;
	
    private boolean  statusId=true;
	
    @NotNull(message = "Origin Group Id  is mandatory")

	private Integer originGroupId ;
	
    @NotNull(message = "Destination Group Id  is mandatory")

	private Integer destinationGroupId ;
	
    @NotNull(message = "Base Price  is mandatory")

	private BigDecimal basePrice;
	
	@DateTimeFormat(pattern="dd.MM.yyyy hh:mm")
	@CreatedDate
	private LocalDateTime  createdAt;
	
    @NotNull(message = "SubProduct Id  is mandatory")

	private SubProduct  subProduct;
	
    @NotNull(message = "Division Id  is mandatory")

	private Division  division;
	
    @NotNull(message = "Product Id  is mandatory")
	private Product  product;


    @NotNull(message = "Temperature Id  is mandatory")

	private Temperature  temperature;
	
	@DateTimeFormat(pattern="dd.MM.yyyy hh:mm")
	@LastModifiedDate
	private LocalDateTime  modifiedAt;
	
	
}



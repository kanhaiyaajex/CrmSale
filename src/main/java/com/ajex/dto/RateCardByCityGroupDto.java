package com.ajex.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.ajex.entity.Division;
import com.ajex.entity.Product;
import com.ajex.entity.SubProduct;
import com.ajex.entity.Temperature;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RateCardByCityGroupDto {
	
private Integer rateCardByCityGroupId;

private String groupName;

private String groupOrderId;

private boolean statusId;

private Integer originGroupId ;

private Integer destinationGroupId ;

private BigDecimal basePrice;

@DateTimeFormat(pattern="dd.MM.yyyy hh:mm")
@CreatedDate
private LocalDateTime  createdAt;

private SubProduct  subProduct;

private Division  division;

private Product  product;



private Temperature  temperature;

@DateTimeFormat(pattern="dd.MM.yyyy hh:mm")
@LastModifiedDate
private LocalDateTime  modifiedAt;

	

}

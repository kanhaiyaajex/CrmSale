package com.ajex.entity;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
public class SubProduct {
	

	@Id
	private String subProductId;
	
	
	private String nameInAr;
	
	private String division;
	
	private boolean statusId;
	
	
	private String measureOfUnitId;
	
	private Date createdDate;
	
	

}

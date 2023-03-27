package com.ajex.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import lombok.Data;




@Data


@Document(collection = "cityGroup")
public class CityGroup {



    @Transient
    public static final String SEQUENCE_NAME = "cityGroup_sequence";
	
	@Id
	private Integer cityGroupId;
	
	
    @NotNull(message = "Group name  is mandatory")

	private String groupName;
	
    @NotNull(message = "Group order Id  is mandatory")

	private String groupOrderId;  //random

    @NotNull(message = "Division Id  is mandatory")
    private Division divisionId;
    
    
    private boolean  statusId=true;
	
	
	
	
	
}



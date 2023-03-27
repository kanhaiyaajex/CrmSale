package com.ajex.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "approvalCity")
public class ApprovalMatrix {

	
	
	@Id
	private String approvalMatrixId;
	
    @NotNull(message = "Division Id  is mandatory")

	private Division divisionId;
	
    private boolean  statusId=true;
	
	
}

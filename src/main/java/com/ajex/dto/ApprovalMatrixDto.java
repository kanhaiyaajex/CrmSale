package com.ajex.dto;

import com.ajex.entity.Division;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApprovalMatrixDto {

	
	
	
private String approvalMatrixId;
	
	private Division division;
	
	private boolean status;
	
	
	
}

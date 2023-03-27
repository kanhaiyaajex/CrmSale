package com.ajex.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeasureOfUnitDto {
	
	private Integer measureOfUnitId;
	
	private String unitName;
	
	private boolean statusId;


}

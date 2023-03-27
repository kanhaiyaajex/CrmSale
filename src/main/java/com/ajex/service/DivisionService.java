package com.ajex.service;

import java.util.List;

import com.ajex.dto.DivisionDto;
import com.ajex.entity.Division;

public interface DivisionService {
	
	public DivisionDto addDivision(Division Division);
	
	public DivisionDto updateDivision(Integer id,Division Division);

	
	public void deleteDivision(Integer id);
	
	
	public List<Division> getAllDivision();

     	

	


}

package com.ajex.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ajex.dto.AdditionalServiceDto;
import com.ajex.entity.AdditionalService;

public interface AdditionalServices {
	
	public AdditionalServiceDto addAdditionalService(AdditionalService AdditionalService);
	
	public ResponseEntity<?> updateAdditionalService(Integer id,AdditionalService AdditionalService) ;

	
	public void deleteAdditionalService(Integer id);
	
	
	public List<AdditionalService> getAllAdditionalService();


     	

	


}

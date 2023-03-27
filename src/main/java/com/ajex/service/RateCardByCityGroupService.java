package com.ajex.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ajex.dto.RateCardByCityGroupDto;
import com.ajex.entity.RateCardByCityGroup;

public interface RateCardByCityGroupService {
	
	public RateCardByCityGroupDto addRateCardByCityGroup(RateCardByCityGroup RateCardByCityGroup);
	
	public ResponseEntity<?> updateRateCardByCityGroup(Integer id,RateCardByCityGroup RateCardByCityGroup) ;

	
	public void deleteRateCardByCityGroup(Integer id);
	
	
	public List<RateCardByCityGroup> getAllRateCardByCityGroup();


     	

	


}

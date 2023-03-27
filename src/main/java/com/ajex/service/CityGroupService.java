package com.ajex.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ajex.dto.CityDto;
import com.ajex.dto.CityGroupDto;
import com.ajex.entity.City;
import com.ajex.entity.CityGroup;

public interface CityGroupService {
	
	public CityGroupDto addCityGroup(CityGroup cityGroup);
	
	public ResponseEntity<?> updateCityGroup(Integer id,CityGroup cityGroup) ;

	
	public void deleteCityGroup(Integer id);
	
	
	public List<CityGroup> getAllCityGroup();


     	

	


}

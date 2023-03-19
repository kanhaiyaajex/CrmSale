package com.ajex.service;

import java.util.List;

import com.ajex.dto.CityDto;
import com.ajex.dto.CityGroupDto;
import com.ajex.entity.City;
import com.ajex.entity.CityGroup;

public interface CityGroupService {
	
	public CityGroupDto addCityGroup(CityGroup cityGroup);
	
	public CityGroupDto updateCityGroup(String id,CityGroup cityGroup);

	
	public void deleteCityGroup(String id);
	
	
	public List<CityGroup> getAllCityGroup();

     	

	


}

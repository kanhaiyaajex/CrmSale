package com.ajex.service;

import java.util.List;

import com.ajex.dto.PortCitiesDto;
import com.ajex.entity.PortCities;

public interface PortCitiesService {
	
	public PortCitiesDto addPortCities(PortCities PortCities);
	
	public PortCitiesDto updatePortCities(String id,PortCities PortCities);

	
	public void deletePortCities(String id);
	
	
	public List<PortCities> getAllPortCities();

     	

	


}

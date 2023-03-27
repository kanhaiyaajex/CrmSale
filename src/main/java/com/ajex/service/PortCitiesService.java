package com.ajex.service;

import java.util.List;

import com.ajex.dto.PortCitiesDto;
import com.ajex.entity.PortCities;

public interface PortCitiesService {
	
	public PortCitiesDto addPortCities(PortCities PortCities);
	
	public PortCitiesDto updatePortCities(Integer id,PortCities PortCities);

	
	public void deletePortCities(Integer id);
	
	
	public List<PortCities> getAllPortCities();

     	

	


}

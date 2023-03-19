package com.ajex.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ajex.dto.CityDto;
import com.ajex.entity.City;

public interface CityService {
	
	public CityDto addCity(City city);
	
	public CityDto updateCity(String id,City city);

	
	public void deleteCity(String id);
	
	
	public List<City> getAllCity();

     	

	


}

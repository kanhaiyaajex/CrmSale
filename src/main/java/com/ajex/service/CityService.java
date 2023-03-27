package com.ajex.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ajex.dto.CityDto;
import com.ajex.entity.City;
import com.ajex.exception.ResourceNotFoundException;

public interface CityService {
	
	public CityDto addCity(City city) throws ResourceNotFoundException;
	
	public ResponseEntity<?> updateCity(Integer id,City city) throws ResourceNotFoundException;

	
	public void deleteCity(Integer id);
	
	
	public List<City> getAllCity();

     	

	


}

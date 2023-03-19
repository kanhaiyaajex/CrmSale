package com.ajex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajex.dto.CityDto;
import com.ajex.entity.City;
import com.ajex.repository.CityRepo;
import com.ajex.service.CityService;

@RestController
@RequestMapping("/api/v1/city/")
public class CityController {

	
	
	@Autowired
	private CityService  cityService;
	

	@Autowired
	private CityRepo  cityRepo;
	
	
	@GetMapping("/getCities")
	public List<City>  getAllCity()
	{
		
		List<City>  allCities= cityService.getAllCity();
		return allCities;
		
	}
	
	
	@PostMapping("/addCity")
	public CityDto  addCity(@RequestBody   City city)
	{
		
		CityDto  cityVal= cityService.addCity(city);
		return cityVal;
		
	}
	
	
	
	@PostMapping("/updateCity/{id}")
	
		public CityDto updateCity(@PathVariable("id") String id, @RequestBody City city) {
			
				  
				  return  cityService.updateCity(id, city);
				  
			  
			 
	}
	
	
	@PostMapping("/deleteCity/{id}")
	public Map<String,Object> deleteCity(@PathVariable String id)
	{
		Map<String,Object> m=new HashMap<>();
		
		try {
		   cityService.deleteCity(id);
		    m.put("boolean", "success");
			m.put("message", "City is deleted successfully");
		}
		
		catch (Exception e) {
			m.put("boolean", "false");
			m.put("message", "City does not exist");
		}
			
		
		
		
		 return m;
		 
		 
		
	}
	
	
	
	
}


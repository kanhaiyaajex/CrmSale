package com.ajex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajex.dto.CityDto;
import com.ajex.entity.City;
import com.ajex.exception.ResourceNotFoundException;
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
	public  ResponseEntity<?>  getAllCity()
	{
		Map<Object,Object> m = new HashMap<>();

		try {
			List<City>  allCities= cityService.getAllCity();
			
             m.put("data",allCities );
			
			m.put("status","OK" );

			m.put("statusCode","200" );
			m.put("boolean","success");

			return new ResponseEntity<>(m, HttpStatus.OK);
			
		}catch (Exception e) {
			
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		
	}
	


	
	
	
	
	@PostMapping("/addCity")
	public ResponseEntity<?> addCity(@Validated @RequestBody City city) throws ResourceNotFoundException{
		
		
			  CityDto  cityVal= cityService.addCity(city);
			  
			return new ResponseEntity<>(cityVal, HttpStatus.CREATED);
			
		
	}
	
	
	@PostMapping("/updateCity/{id}")
	
		public ResponseEntity<?> updateCity(@Validated @PathVariable("id") Integer id, @RequestBody City city) throws ResourceNotFoundException  {
			
		 
	    ResponseEntity<?>  cityUpdated = cityService.updateCity(id,city);
		
		return new ResponseEntity<>(cityUpdated, HttpStatus.CREATED);
		
		
	}
	
	
	@PostMapping("/deleteCity/{id}")
	public Map<String,Object> deleteCity(@PathVariable Integer id)
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


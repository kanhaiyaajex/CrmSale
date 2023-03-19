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

import com.ajex.dto.CountryDto;
import com.ajex.entity.Country;
import com.ajex.repository.CountryRepo;
import com.ajex.service.CountryService;

@RestController
@RequestMapping("/api/v1/country/")
public class CountryController {

	
	
	@Autowired
	private CountryService  CountryService;
	

	@Autowired
	private CountryRepo  CountryRepo;
	
	
	@GetMapping("/getCities")
	public List<Country>  getAllCountry()
	{
		
		List<Country>  allCities= CountryService.getAllCountries();
		return allCities;
		
	}
	
	
	@PostMapping("/addCountry")
	public CountryDto  addCountry(@RequestBody   Country Country)
	{
		
		CountryDto  CountryVal= CountryService.addCountry(Country);
		return CountryVal;
		
	}
	
	
	
	@PostMapping("/updateCountry/{id}")
	
		public CountryDto updateCountry(@PathVariable("id") String id, @RequestBody Country Country) {
			
				  
				  return  CountryService.updateCountry(id, Country);
				  
			  
			 
	}
	
	
	@PostMapping("/deleteCountry/{id}")
	public Map<String,Object> deleteCountry(@PathVariable String id)
	{
		Map<String,Object> m=new HashMap<>();
		
		try {
		   CountryService.deleteCountry(id);
		    m.put("boolean", "success");
			m.put("message", "Country is deleted successfully");
		}
		
		catch (Exception e) {
			m.put("boolean", "false");
			m.put("message", "Country does not exist");
		}
			
		
		
		
		 return m;
		 
		 
		
	}
	
	
	
	
}


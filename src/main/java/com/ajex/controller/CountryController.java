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

import com.ajex.dto.CountryDto;
import com.ajex.entity.CityGroup;
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
	
	
	@GetMapping("/getCountries")
	public ResponseEntity<?>  getAllCountry()
	{
		Map<Object,Object> m = new HashMap<>();

		List<Country>  allCountries= CountryService.getAllCountries();
		
		
		

			
             m.put("data",allCountries );
			
			m.put("status","OK" );

			m.put("statusCode","200" );
			m.put("boolean","success");
			
			 return new ResponseEntity<>(m, HttpStatus.OK);
			 
		
	}
	
	
	@PostMapping("/addCountry")
	public CountryDto  addCountry(@RequestBody   Country Country)
	{
		
		CountryDto  CountryVal= CountryService.addCountry(Country);
		return CountryVal;
		
	}
	
	
	
	@PostMapping("/updateCountry")
	
		public CountryDto updateCountry(@Validated @RequestBody Country country) {
			
				  
				  return  CountryService.updateCountry(country);
				  
			  
			 
	}
	
	
	@PostMapping("/deleteCountry/{id}")
	public Map<String,Object> deleteCountry(@PathVariable Integer id)
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


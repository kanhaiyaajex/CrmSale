package com.ajex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajex.dto.PortCitiesDto;
import com.ajex.entity.MeasureOfUnit;
import com.ajex.entity.PortCities;
import com.ajex.repository.PortCitiesRepo;
import com.ajex.service.PortCitiesService;

@RestController
@RequestMapping("/api/v1/portCity/")
public class PortCitiesController {

	
	
	@Autowired
	private PortCitiesService  PortCitiesService;
	

	@Autowired
	private PortCitiesRepo  PortCitiesRepo;
	
	
	@GetMapping("/getCities")
	public  ResponseEntity<?>  getAllPortCities()
	{
		
		List<PortCities>  allPortCities= PortCitiesService.getAllPortCities();
		

		
		
		Map<Object,Object> m = new HashMap<>();

		
		
		

			
             m.put("data",allPortCities );
			
			m.put("status","OK" );

			m.put("statusCode","200" );
			m.put("boolean","success");
			
			 return new ResponseEntity<>(m, HttpStatus.OK);
		
		
	}
	
	
	@PostMapping("/addPortCities")
	public PortCitiesDto  addPortCities(@RequestBody   PortCities PortCities)
	{
		
		PortCitiesDto  PortCitiesVal= PortCitiesService.addPortCities(PortCities);
		return PortCitiesVal;
		
	}
	
	
	
	@PostMapping("/updatePortCities/{id}")
	
		public PortCitiesDto updatePortCities(@PathVariable("id") Integer id, @RequestBody PortCities PortCities) {
			
				  
				  return  PortCitiesService.updatePortCities(id, PortCities);
				  
			  
			 
	}
	
	
	@PostMapping("/deletePortCities/{id}")
	public Map<String,Object> deletePortCities(@PathVariable Integer id)
	{
		Map<String,Object> m=new HashMap<>();
		
		try {
		   PortCitiesService.deletePortCities(id);
		    m.put("boolean", "success");
			m.put("message", "PortCities is deleted successfully");
		}
		
		catch (Exception e) {
			m.put("boolean", "false");
			m.put("message", "PortCities does not exist");
		}
			
		
		
		
		 return m;
		 
		 
		
	}
	
	
	
	
}


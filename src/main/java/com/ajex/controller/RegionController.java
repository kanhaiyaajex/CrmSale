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

import com.ajex.dto.RegionDto;
import com.ajex.entity.Region;
import com.ajex.repository.RegionRepo;
import com.ajex.service.RegionService;

@RestController
@RequestMapping("/api/v1/region/")
public class RegionController {

	
	
	@Autowired
	private RegionService  RegionService;
	

	@Autowired
	private RegionRepo  RegionRepo;
	
	
	@GetMapping("/getCities")
	public List<Region>  getAllRegion()
	{
		
		List<Region>  allCities= RegionService.getAllRegion();
		return allCities;
		
	}
	
	
	@PostMapping("/addRegion")
	public RegionDto  addRegion(@RequestBody   Region Region)
	{
		
		RegionDto  RegionVal= RegionService.addRegion(Region);
		return RegionVal;
		
	}
	
	
	
	@PostMapping("/updateRegion/{id}")
	
		public RegionDto updateRegion(@PathVariable("id") String id, @RequestBody Region Region) {
			
				  
				  return  RegionService.updateRegion(id, Region);
				  
			  
			 
	}
	
	
	@PostMapping("/deleteRegion/{id}")
	public Map<String,Object> deleteRegion(@PathVariable String id)
	{
		Map<String,Object> m=new HashMap<>();
		
		try {
		   RegionService.deleteRegion(id);
		    m.put("boolean", "success");
			m.put("message", "Region is deleted successfully");
		}
		
		catch (Exception e) {
			m.put("boolean", "false");
			m.put("message", "Region does not exist");
		}
			
		
		
		
		 return m;
		 
		 
		
	}
	
	
	
	
}


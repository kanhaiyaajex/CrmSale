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

import com.ajex.dto.CityGroupDto;
import com.ajex.entity.CityGroup;
import com.ajex.repository.CityGroupRepo;
import com.ajex.service.CityGroupService;

@RestController
@RequestMapping("/api/v1/city_gr/")
public class CityGroupController {

	
	
	@Autowired
	private CityGroupService  CityGroupService;
	

	@Autowired
	private CityGroupRepo  CityGroupRepo;
	
	
	@GetMapping("/getCities")
	public List<CityGroup>  getAllCityGroup()
	{
		
		List<CityGroup>  allCities= CityGroupService.getAllCityGroup();
		return allCities;
		
	}
	
	
	@PostMapping("/addCityGroup")
	public CityGroupDto  addCityGroup(@RequestBody   CityGroup CityGroup)
	{
		
		CityGroupDto  CityGroupVal= CityGroupService.addCityGroup(CityGroup);
		return CityGroupVal;
		
	}
	
	
	
	@PostMapping("/updateCityGroup/{id}")
	
		public CityGroupDto updateCityGroup(@PathVariable("id") String id, @RequestBody CityGroup CityGroup) {
			
				  
				  return  CityGroupService.updateCityGroup(id, CityGroup);
				  
			  
			 
	}
	
	
	@PostMapping("/deleteCityGroup/{id}")
	public Map<String,Object> deleteCityGroup(@PathVariable String id)
	{
		Map<String,Object> m=new HashMap<>();
		
		try {
		   CityGroupService.deleteCityGroup(id);
		    m.put("boolean", "success");
			m.put("message", "CityGroup is deleted successfully");
		}
		
		catch (Exception e) {
			m.put("boolean", "false");
			m.put("message", "CityGroup does not exist");
		}
			
		
		
		
		 return m;
		 
		 
		
	}
	
	
	
	
}


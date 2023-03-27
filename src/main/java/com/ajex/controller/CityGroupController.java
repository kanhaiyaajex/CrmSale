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

import com.ajex.dto.CityGroupDto;
import com.ajex.entity.City;
import com.ajex.entity.CityGroup;
import com.ajex.repository.CityGroupRepo;
import com.ajex.service.CityGroupService;

@RestController
@RequestMapping("/api/v1/cityGroup/")
public class CityGroupController {

	
	
	@Autowired
	private CityGroupService  CityGroupService;
	

	@Autowired
	private CityGroupRepo  CityGroupRepo;
	
	
	@GetMapping("/getCityGroups")
	public ResponseEntity<?> getAllCityGroup()
	{
		Map<Object,Object> m = new HashMap<>();
		List<CityGroup>  allCities= CityGroupService.getAllCityGroup();
		
		

			
             m.put("data",allCities );
			
			m.put("status","OK" );

			m.put("statusCode","200" );
			m.put("boolean","success");

	     return new ResponseEntity<>(m, HttpStatus.OK);

		
	}
	
	
	@PostMapping("/addCityGroup")
	public CityGroupDto  addCityGroup(@RequestBody   CityGroup CityGroup)
	{
		
		CityGroupDto  CityGroupVal= CityGroupService.addCityGroup(CityGroup);
		return CityGroupVal;
		
	}
	
	
	
	@PostMapping("/updateCityGroup/{id}")
	 
		public ResponseEntity<?>  updateCityGroup(@PathVariable int id, @RequestBody CityGroup cityGroup) {
			
				  
		
		 ResponseEntity<?>  cityGroupUpdated = CityGroupService.updateCityGroup(id, cityGroup);
			
	     return new ResponseEntity<>(cityGroupUpdated, HttpStatus.CREATED);
			
			
				  
			  
			 
	}
	
	
	@PostMapping("/deleteCityGroup/{id}")
	public Map<String,Object> deleteCityGroup(@PathVariable Integer id)
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


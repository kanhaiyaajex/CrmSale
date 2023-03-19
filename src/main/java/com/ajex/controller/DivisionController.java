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

import com.ajex.dto.DivisionDto;
import com.ajex.entity.Division;
import com.ajex.repository.DivisionRepo;
import com.ajex.service.DivisionService;

@RestController
@RequestMapping("/api/v1/division/")
public class DivisionController {

	
	
	@Autowired
	private DivisionService  DivisionService;
	

	@Autowired
	private DivisionRepo  DivisionRepo;
	
	
	@GetMapping("/getCities")
	public List<Division>  getAllDivision()
	{
		
		List<Division>  allCities= DivisionService.getAllDivision();
		return allCities;
		
	}
	
	
	@PostMapping("/addDivision")
	public DivisionDto  addDivision(@RequestBody   Division Division)
	{
		
		DivisionDto  DivisionVal= DivisionService.addDivision(Division);
		return DivisionVal;
		
	}
	
	
	
	@PostMapping("/updateDivision/{id}")
	
		public DivisionDto updateDivision(@PathVariable("id") String id, @RequestBody Division Division) {
			
				  
				  return  DivisionService.updateDivision(id, Division);
				  
			  
			 
	}
	
	
	@PostMapping("/deleteDivision/{id}")
	public Map<String,Object> deleteDivision(@PathVariable String id)
	{
		Map<String,Object> m=new HashMap<>();
		
		try {
		   DivisionService.deleteDivision(id);
		    m.put("boolean", "success");
			m.put("message", "Division is deleted successfully");
		}
		
		catch (Exception e) {
			m.put("boolean", "false");
			m.put("message", "Division does not exist");
		}
			
		
		
		
		 return m;
		 
		 
		
	}
	
	
	
	
}


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

import com.ajex.dto.PositionDto;
import com.ajex.entity.Position;
import com.ajex.repository.PositionRepo;
import com.ajex.service.PositionService;

@RestController
@RequestMapping("/api/v1/position/")
public class PositionController {

	
	
	@Autowired
	private PositionService  PositionService;
	

	@Autowired
	private PositionRepo  PositionRepo;
	
	
	@GetMapping("/getCities")
	public List<Position>  getAllPosition()
	{
		
		List<Position>  allCities= PositionService.getAllPosition();
		return allCities;
		
	}
	
	
	@PostMapping("/addPosition")
	public PositionDto  addPosition(@RequestBody   Position Position)
	{
		
		PositionDto  PositionVal= PositionService.addPosition(Position);
		return PositionVal;
		
	}
	
	
	
	@PostMapping("/updatePosition/{id}")
	
		public PositionDto updatePosition(@PathVariable("id") String id, @RequestBody Position Position) {
			
				  
				  return  PositionService.updatePosition(id, Position);
				  
			  
			 
	}
	
	
	@PostMapping("/deletePosition/{id}")
	public Map<String,Object> deletePosition(@PathVariable String id)
	{
		Map<String,Object> m=new HashMap<>();
		
		try {
		   PositionService.deletePosition(id);
		    m.put("boolean", "success");
			m.put("message", "Position is deleted successfully");
		}
		
		catch (Exception e) {
			m.put("boolean", "false");
			m.put("message", "Position does not exist");
		}
			
		
		
		
		 return m;
		 
		 
		
	}
	
	
	
	
}


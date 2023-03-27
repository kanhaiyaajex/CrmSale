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

import com.ajex.dto.RegionDto;
import com.ajex.entity.Region;
import com.ajex.exception.ResourceNotFoundException;
import com.ajex.repository.RegionRepo;
import com.ajex.service.RegionService;


@RestController
@RequestMapping("/api/v1/region/")
public class RegionController {

	
	
	@Autowired
	private RegionService  RegionService;
	

	@Autowired
	private RegionRepo  RegionRepo;
	
	
	@GetMapping("/getRegions")
	public ResponseEntity<?>  getAllRegion()
	{
		
		List<Region>  allRegs= RegionService.getAllRegion();
		
Map<Object,Object> m = new HashMap<>();

		
		
		

		
        m.put("data",allRegs );
		
		m.put("status","OK" );

		m.put("statusCode","200" );
		m.put("boolean","success");
		
		 return new ResponseEntity<>(m, HttpStatus.OK);   
		
	}
	
	
	@PostMapping("/addRegion")
	public RegionDto  addRegion(@Validated @RequestBody    Region region) throws ResourceNotFoundException
	{
		
		RegionDto  RegionVal= RegionService.addRegion(region);
		return RegionVal;
		
	}
	
	
	
	@PostMapping("/updateRegion")
	
		public RegionDto updateRegion(@Validated @RequestBody Region region) throws ResourceNotFoundException {
			
				  
				  return  RegionService.updateRegion(region);
				  
			  
			 
	}
	
	
	@PostMapping("/deleteRegion/{id}")
	public Map<String,Object> deleteRegion(@PathVariable Integer id)
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


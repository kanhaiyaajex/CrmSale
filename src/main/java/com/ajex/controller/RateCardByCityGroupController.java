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

import com.ajex.dto.RateCardByCityGroupDto;
import com.ajex.entity.RateCardByCityGroup;
import com.ajex.repository.RateCardByCityGroupRepo;
import com.ajex.service.RateCardByCityGroupService;

@RestController
@RequestMapping("/api/v1/rateCardByRateCardByCity/")
public class RateCardByCityGroupController
{

	
	
	@Autowired
	private RateCardByCityGroupService  RateCardByCityService;
	

	@Autowired
	private RateCardByCityGroupRepo  RateCardByCityRepo;
	
	
	@GetMapping("/getRateCardByCitys")
	public ResponseEntity<List<RateCardByCityGroup>> getAllRateCardByCity()
	{
		
		List<RateCardByCityGroup>  allCities= RateCardByCityService.getAllRateCardByCityGroup();
		
		
		
	     return new ResponseEntity<>(allCities, HttpStatus.OK);

		
	}
	
	
	@PostMapping("/addRateCardByCity")
	public RateCardByCityGroupDto  addRateCardByCity(@RequestBody   RateCardByCityGroup RateCardByCity)
	{
		
		RateCardByCityGroupDto  RateCardByCityVal= RateCardByCityService.addRateCardByCityGroup(RateCardByCity);
		return RateCardByCityVal;
		
	}
	
	
	
	@PostMapping("/updateRateCardByCity/{id}")
	 
		public ResponseEntity<?>  updateRateCardByCity(@PathVariable int id, @RequestBody RateCardByCityGroup RateCardByCity) {
			
				  
		
		 ResponseEntity<?>  RateCardByCityUpdated = RateCardByCityService.updateRateCardByCityGroup(id, RateCardByCity);
			
	     return new ResponseEntity<>(RateCardByCityUpdated, HttpStatus.CREATED);
			
			
				  
			  
			 
	}
	
	
	@PostMapping("/deleteRateCardByCity/{id}")
	public Map<String,Object> deleteRateCardByCity(@PathVariable Integer id)
	{
		Map<String,Object> m=new HashMap<>();
		
		try {
		   RateCardByCityService.deleteRateCardByCityGroup(id);
		    m.put("boolean", "success");
			m.put("message", "RateCardByCity is deleted successfully");
		}
		
		catch (Exception e) {
			m.put("boolean", "false");
			m.put("message", "RateCardByCity does not exist");
		}
			
		
		
		
		 return m;
		 
		 
		
	}
	
	
	
	
}


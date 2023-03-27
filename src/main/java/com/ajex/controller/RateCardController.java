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

import com.ajex.dto.RateCardDto;
import com.ajex.entity.RateCard;
import com.ajex.exception.ResourceNotFoundException;
import com.ajex.repository.RateCardRepo;
import com.ajex.service.RateCardService;

@RestController
@RequestMapping("/api/v1/rateCard/")
public class RateCardController {

	
	
	@Autowired
	private RateCardService  RateCardService;
	

	@Autowired
	private RateCardRepo  RateCardRepo;
	
	
	@GetMapping("/getRateCards")
	public ResponseEntity<?>  getAllRateCard()
	{
		
		List<RateCard>  allRateCards= RateCardService.getAllRateCard();
		
Map<Object,Object> m = new HashMap<>();

		
		
		

		
        m.put("data",allRateCards );
		
		m.put("status","OK" );

		m.put("statusCode","200" );
		m.put("boolean","success");
		
		 return new ResponseEntity<>(m, HttpStatus.OK);      
		
	}
	
	
	@PostMapping("/addRateCard")
	public RateCardDto  addRateCard(@RequestBody   RateCard RateCard) throws ResourceNotFoundException
	{
		
		RateCardDto  RateCardVal= RateCardService.addRateCard(RateCard);
		return RateCardVal;
		
	}
	
	
	
	@PostMapping("/updateRateCard/{id}")
	
		public RateCardDto updateRateCard(@PathVariable("id") Integer id, @RequestBody RateCard RateCard) {
			
				  
				  return  RateCardService.updateRateCard(id, RateCard);
				  
			  
			 
	}
	
	
	@PostMapping("/deleteRateCard/{id}")
	public Map<String,Object> deleteRateCard(@PathVariable Integer id)
	{
		Map<String,Object> m=new HashMap<>();
		
		try {
		   RateCardService.deleteRateCard(id);
		    m.put("boolean", "success");
			m.put("message", "RateCard is deleted successfully");
		}
		
		catch (Exception e) {
			m.put("boolean", "false");
			m.put("message", "RateCard does not exist");
		}
			
		
		
		
		 return m;
		 
		 
		
	}
	
	
	
	
}


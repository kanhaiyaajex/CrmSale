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

import com.ajex.dto.DivisionDto;
import com.ajex.entity.Country;
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
	
	
	@GetMapping("/getDivisions")
	public ResponseEntity<?> getAllDivision()
	{
		
		List<Division>  allDivs= DivisionService.getAllDivision();
		Map<Object,Object> m = new HashMap<>();

		
		
		

			
             m.put("data",allDivs );
			
			m.put("status","OK" );

			m.put("statusCode","200" );
			m.put("boolean","success");
			
			 return new ResponseEntity<>(m, HttpStatus.OK);
		
	}
	
	
	@PostMapping("/addDivision")
	public ResponseEntity<?>  addDivision(@RequestBody   Division Division)
	{
		

		DivisionDto  DivisionVal= DivisionService.addDivision(Division);
		Map<Object,Object> m = new HashMap<>();
		 m.put("data",DivisionVal );
			
			m.put("status","OK" );

			m.put("statusCode","201" );
			m.put("boolean","success");
			
			 return new ResponseEntity<>(m, HttpStatus.OK);		
	}
	
	
	
	@PostMapping("/updateDivision/{id}")
	
		public ResponseEntity<?> updateDivision(@PathVariable("id") Integer id, @RequestBody Division Division) {
			
				  
		DivisionDto  DivisionVal= DivisionService.updateDivision(id, Division);
					Map<Object,Object> m = new HashMap<>();
					 m.put("data",DivisionVal );
						
						m.put("status","OK" );

						m.put("statusCode","201" );
						m.put("boolean","success");
						
						 return new ResponseEntity<>(m, HttpStatus.OK);	
				  
			  
			 
	}
	
	
	@PostMapping("/deleteDivision/{id}")
	public Map<String,Object> deleteDivision(@PathVariable Integer id)
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


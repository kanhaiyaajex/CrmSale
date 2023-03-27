package com.ajex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajex.dto.MeasureOfUnitDto;
import com.ajex.entity.Employee;
import com.ajex.entity.MeasureOfUnit;
import com.ajex.repository.MeasureOfUnitRepo;
import com.ajex.service.MeasureOfUnitService;


@RestController
@RequestMapping("/api/v1/measureOfUnit/")
public class MeasureOfUnitController {
	
	

	
	@Autowired
	private MeasureOfUnitService  MeasureOfUnitService;
	

	@Autowired
	private MeasureOfUnitRepo  MeasureOfUnitRepo;
	
	
	@GetMapping("/getUnits")
	public ResponseEntity<?>  getAllMeasureOfUnit()
	{
		
		List<MeasureOfUnit>  allUnits= MeasureOfUnitService.getAllMeasureOfUnit();
		
		
		Map<Object,Object> m = new HashMap<>();

		
		
		

			
             m.put("data",allUnits );
			
			m.put("status","OK" );

			m.put("statusCode","200" );
			m.put("boolean","success");
			
			 return new ResponseEntity<>(m, HttpStatus.OK);
		
	}
	
	
	@PostMapping("/addMeasureOfUnit")
	public MeasureOfUnitDto  addMeasureOfUnit(@RequestBody   MeasureOfUnit MeasureOfUnit)
	{
		
		MeasureOfUnitDto  MeasureOfUnitVal= MeasureOfUnitService.addMeasureOfUnit(MeasureOfUnit);
		return MeasureOfUnitVal;
		
	}
	
	
	
	@PostMapping("/updateMeasureOfUnit/{id}")
	
		public ResponseEntity<?> updateMeasureOfUnit(@PathVariable("id") Integer id, @RequestBody MeasureOfUnit MeasureOfUnit) {
			
				  
				  return  MeasureOfUnitService.updateMeasureOfUnit(id, MeasureOfUnit);
				  
			  
			 
	}
	
	
	@PostMapping("/deleteMeasureOfUnit/{id}")
	public Map<String,Object> deleteMeasureOfUnit(@PathVariable Integer id)
	{
		Map<String,Object> m=new HashMap<>();
		
		try {
		   MeasureOfUnitService.deleteMeasureOfUnit(id);
		    m.put("boolean", "success");
			m.put("message", "MeasureOfUnit is deleted successfully");
		}
		
		catch (Exception e) {
			m.put("boolean", "false");
			m.put("message", "MeasureOfUnit does not exist");
		}
			
		
		
		
		 return m;
		 
		 
		
	}
	
	
	
	
}







//package com.ajex.controller;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ajex.dto.AdditionalServiceDto;
//import com.ajex.entity.AdditionalService;
//import com.ajex.repository.AdditionalServiceRepo;
//import com.ajex.service.AdditionalServices;
//
//@RestController
//@RequestMapping("/api/v1/additionalService/")
//public class AdditionalServiceController {
//
//	
//
//	@Autowired
//	private ModelMapper modelMapper;
//	
//	
//	
//	@Autowired
//	private AdditionalServices  AdditionalServiceService;
//	
//
//	@Autowired
//	private AdditionalServiceRepo  AdditionalServiceRepo;
//	
//	
//	@GetMapping("/getAddlServices")
//	public  ResponseEntity<?>  getAllAdditionalService()
//	{
//		Map<Object,Object> m = new HashMap<>();
//		try {
//			List<AdditionalService>  allServices= AdditionalServiceService.getAllAdditionalService();
//			
//			
//			m.put("data",allServices );
//			
//			m.put("status","OK" );
//
//			m.put("statusCode","200" );
//			m.put("boolean","success");
//
//
//			return new ResponseEntity<>(m, HttpStatus.OK);
//			
//		}catch (Exception e) {
//			
//			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
//		}
//		
//	}
//	
//
//
//	
//	
//	
//	
//	@PostMapping("/addAdditionalService")
//	public ResponseEntity<?> addAdditionalService(@RequestBody AdditionalService AdditionalService){
//		try {
//			  AdditionalServiceDto  AdditionalServiceVal= AdditionalServiceService.addAdditionalService(AdditionalService);
//			return new ResponseEntity<>(AdditionalServiceVal, HttpStatus.CREATED);
//		}catch (Exception e) {
//			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
//		}
//	}
//	
//	
//	@PostMapping("/updateAdditionalService/{id}")
//	
//		public ResponseEntity<?> updateAdditionalService(@PathVariable("id") Integer id, @RequestBody AdditionalService AdditionalService)  {
//			
//		 
//	    ResponseEntity<?>  AdditionalServiceUpdated = AdditionalServiceService.updateAdditionalService(id,AdditionalService);
//		
//		return new ResponseEntity<>(AdditionalServiceUpdated, HttpStatus.CREATED);
//		
//		
//	}
//	
//	
//	@PostMapping("/deleteAdditionalService/{id}")
//	public Map<String,Object> deleteAdditionalService(@PathVariable Integer id)
//	{
//		Map<String,Object> m=new HashMap<>();
//		
//		try {
//		   AdditionalServiceService.deleteAdditionalService(id);
//		    m.put("boolean", "success");
//			m.put("message", "AdditionalService is deleted successfully");
//		}
//		
//		catch (Exception e) {
//			m.put("boolean", "false");
//			m.put("message", "AdditionalService does not exist");
//		}
//			
//		
//		
//		
//		 return m;
//		 
//		 
//		
//	}
//	
//	
//	
//	
//}
//

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

import com.ajex.dto.EmployeeDto;
import com.ajex.entity.Division;
import com.ajex.entity.Employee;
import com.ajex.repository.EmployeeRepo;
import com.ajex.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee/")
public class EmployeeController {

	
	
	@Autowired
	private EmployeeService  EmployeeService;
	

	@Autowired
	private EmployeeRepo  EmployeeRepo;
	
	
	@GetMapping("/getEmployees")
	public ResponseEntity<?>  getAllEmployee()
	{
		
		List<Employee>  allEmp= EmployeeService.getAllEmployee();
		
		Map<Object,Object> m = new HashMap<>();

		
		
		

			
             m.put("data",allEmp );
			
			m.put("status","OK" );

			m.put("statusCode","200" );
			m.put("boolean","success");
			
			 return new ResponseEntity<>(m, HttpStatus.OK);
		
	}
	
	
	@PostMapping("/addEmployee")
	public EmployeeDto  addEmployee(@RequestBody   Employee Employee)
	{
		
		EmployeeDto  EmployeeVal= EmployeeService.addEmployee(Employee);
		return EmployeeVal;
		
	}
	
	
	
	@PostMapping("/updateEmployee/{id}")
	
		public EmployeeDto updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee Employee) {
			
				  
				  return  EmployeeService.updateEmployee(id, Employee);
				  
			  
			 
	}
	
	
	@PostMapping("/deleteEmployee/{id}")
	public Map<String,Object> deleteEmployee(@PathVariable Integer id)
	{
		Map<String,Object> m=new HashMap<>();
		
		try {
		   EmployeeService.deleteEmployee(id);
		    m.put("boolean", "success");
			m.put("message", "Employee is deleted successfully");
		}
		
		catch (Exception e) {
			m.put("boolean", "false");
			m.put("message", "Employee does not exist");
		}
			
		
		
		
		 return m;
		 
		 
		
	}
	
	
	
	
}


package com.ajex.service;

import java.util.List;

import com.ajex.dto.EmployeeDto;
import com.ajex.entity.Employee;

public interface EmployeeService {
	
	public EmployeeDto addEmployee(Employee Employee);
	
	public EmployeeDto updateEmployee(String id,Employee Employee);

	
	public void deleteEmployee(String id);
	
	
	public List<Employee> getAllEmployee();

     	

	


}

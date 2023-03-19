package com.ajex.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ajex.dto.EmployeeDto;
import com.ajex.entity.Employee;
import com.ajex.repository.EmployeeRepo;
import com.ajex.service.EmployeeService;



@Service
public class EmployeeServiceImpl implements EmployeeService {



@Autowired
private EmployeeRepo  EmployeeRepo;


	@Override
	public EmployeeDto addEmployee(Employee Employee) {
  
		
		Employee EmployeeValue=EmployeeRepo.save(Employee);
		EmployeeDto EmployeeDto = new ModelMapper().map(EmployeeValue, EmployeeDto.class);

		return EmployeeDto;
	}

	@Override
	public EmployeeDto updateEmployee(String id,Employee Employee) {

		EmployeeDto EmployeeDto=null;
		Optional<Employee> EmployeeData = EmployeeRepo.findById(id);

		  if (EmployeeData.isPresent()) {
		    Employee EmployeeVal = new Employee();
		    EmployeeVal.setEmpId(id);
//		    EmployeeVal.setEmployeeNameInAr(Employee.getEmployeeNameInAr());
//		    EmployeeVal.setEmployeeCode(Employee.getEmployeeCode());
//		    EmployeeVal.setCountryId(Employee.getCountryId());
//		    EmployeeVal.setRegionId(Employee.getRegionId());
//		    EmployeeVal.setStatusId(Employee.isStatusId());
		    
		    EmployeeRepo.save(Employee);
			EmployeeDto = new ModelMapper().map(EmployeeRepo.save(Employee), EmployeeDto.class);

		  }
		  return EmployeeDto;	}



	@Override
	public void deleteEmployee(String id) {

		Employee EmployeeValue= EmployeeRepo.findById(id).get();
		
		if(EmployeeValue!=null)
		{
			EmployeeRepo.delete(EmployeeValue);
			
		}
	}

	@Override
	public List<Employee> getAllEmployee() {
		
      List<Employee> EmployeeValue= EmployeeRepo.findAll();

		
		if(!EmployeeValue.isEmpty())
				
		{
			return EmployeeValue;
		}
		return EmployeeValue;
	}

}

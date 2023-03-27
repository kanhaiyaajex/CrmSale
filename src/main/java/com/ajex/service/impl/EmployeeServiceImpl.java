package com.ajex.service.impl;

import java.util.List;
import java.util.Optional;

import static com.ajex.entity.Employee.*;

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
private com.ajex.entity.SequenceGeneratorService service;

@Autowired
private EmployeeRepo  EmployeeRepo;


	@Override
	public EmployeeDto addEmployee(Employee employee) {
  
		employee.setEmpId(service.getSequenceNumber(SEQUENCE_NAME));
		Employee EmployeeValue=EmployeeRepo.save(employee);
		EmployeeDto EmployeeDto = new ModelMapper().map(EmployeeValue, EmployeeDto.class);

		return EmployeeDto;
	}

	@Override
	public EmployeeDto updateEmployee(Integer id,Employee employee) {

		EmployeeDto EmployeeDto=null;
		Optional<Employee> EmployeeData = EmployeeRepo.findById(id);

		  if (EmployeeData.isPresent()) {
		    Employee EmployeeVal = new Employee();
		    EmployeeVal.setEmpId(id);
		    EmployeeVal.setName(employee.getName());
		    EmployeeVal.setCountryId(employee.getCountryId());
		    EmployeeVal.setRegionId(employee.getRegionId());
		    EmployeeVal.setStatusId(employee.isStatusId());
		    
		   
			EmployeeDto = new ModelMapper().map(EmployeeRepo.save(employee), EmployeeDto.class);

		  }
		  return EmployeeDto;	}



	@Override
	public void deleteEmployee(Integer id) {

		Employee EmployeeValue= EmployeeRepo.findById( id).get();
		
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

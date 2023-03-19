package com.ajex.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ajex.dto.DivisionDto;
import com.ajex.entity.Division;
import com.ajex.repository.DivisionRepo;
import com.ajex.service.DivisionService;



@Service
public class DivisionServiceImpl implements DivisionService {



@Autowired
private DivisionRepo  DivisionRepo;


	@Override
	public DivisionDto addDivision(Division Division) {
  
		
		Division DivisionValue=DivisionRepo.save(Division);
		DivisionDto DivisionDto = new ModelMapper().map(DivisionValue, DivisionDto.class);

		return DivisionDto;
	}

	@Override
	public DivisionDto updateDivision(String id,Division Division) {

		DivisionDto DivisionDto=null;
		Optional<Division> DivisionData = DivisionRepo.findById(id);

		  if (DivisionData.isPresent()) {
		    Division DivisionVal = new Division();
//		    DivisionVal.setDivisionId(id);
//		    DivisionVal.setDivisionNameInAr(Division.getDivisionNameInAr());
//		    DivisionVal.setDivisionCode(Division.getDivisionCode());
//		    DivisionVal.setCountryId(Division.getCountryId());
//		    DivisionVal.setRegionId(Division.getRegionId());
//		    DivisionVal.setStatusId(Division.isStatusId());
		    
		    DivisionRepo.save(Division);
			DivisionDto = new ModelMapper().map(DivisionRepo.save(Division), DivisionDto.class);

		  }
		  return DivisionDto;	}



	@Override
	public void deleteDivision(String id) {

		Division DivisionValue= DivisionRepo.findById(id).get();
		
		if(DivisionValue!=null)
		{
			DivisionRepo.delete(DivisionValue);
			
		}
	}
	@Override
	public List<Division> getAllDivision() {
		
      List<Division> DivisionValue= DivisionRepo.findAll();

		
		if(!DivisionValue.isEmpty())
				
		{
			return DivisionValue;
		}
		return DivisionValue;
	}

	

}

package com.ajex.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ajex.dto.PortCitiesDto;
import com.ajex.entity.PortCities;
import com.ajex.repository.PortCitiesRepo;
import com.ajex.service.PortCitiesService;



@Service
public class PortCitiesServiceImpl implements PortCitiesService {



@Autowired
private PortCitiesRepo  PortCitiesRepo;


	@Override
	public PortCitiesDto addPortCities(PortCities PortCities) {
  
		
		PortCities PortCitiesValue=PortCitiesRepo.save(PortCities);
		PortCitiesDto PortCitiesDto = new ModelMapper().map(PortCitiesValue, PortCitiesDto.class);

		return PortCitiesDto;
	}

	@Override
	public PortCitiesDto updatePortCities(String id,PortCities PortCities) {

		PortCitiesDto PortCitiesDto=null;
		Optional<PortCities> PortCitiesData = PortCitiesRepo.findById(id);

		  if (PortCitiesData.isPresent()) {
		    PortCities PortCitiesVal = new PortCities();
//		    PortCitiesVal.setPortCitiesId(id);
//		    PortCitiesVal.setPortCitiesNameInAr(PortCities.getPortCitiesNameInAr());
//		    PortCitiesVal.setPortCitiesCode(PortCities.getPortCitiesCode());
//		    PortCitiesVal.setCountryId(PortCities.getCountryId());
//		    PortCitiesVal.setRegionId(PortCities.getRegionId());
//		    PortCitiesVal.setStatusId(PortCities.isStatusId());
		    
		    PortCitiesRepo.save(PortCities);
			PortCitiesDto = new ModelMapper().map(PortCitiesRepo.save(PortCities), PortCitiesDto.class);

		  }
		  return PortCitiesDto;	}



	@Override
	public void deletePortCities(String id) {

		PortCities PortCitiesValue= PortCitiesRepo.findById(id).get();
		
		if(PortCitiesValue!=null)
		{
			PortCitiesRepo.delete(PortCitiesValue);
			
		}
	}

	@Override
	public List<PortCities> getAllPortCities() {
		
      List<PortCities> PortCitiesValue= PortCitiesRepo.findAll();

		
		if(!PortCitiesValue.isEmpty())
				
		{
			return PortCitiesValue;
		}
		return PortCitiesValue;
	}

}

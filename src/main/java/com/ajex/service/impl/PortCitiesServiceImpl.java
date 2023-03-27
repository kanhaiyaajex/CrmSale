package com.ajex.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.ajex.entity.PortCities.*;


import com.ajex.dto.PortCitiesDto;
import com.ajex.entity.PortCities;
import com.ajex.repository.PortCitiesRepo;
import com.ajex.service.PortCitiesService;



@Service
public class PortCitiesServiceImpl implements PortCitiesService {



@Autowired
private com.ajex.entity.SequenceGeneratorService service;




@Autowired
private PortCitiesRepo  PortCitiesRepo;


	@Override
	public PortCitiesDto addPortCities(PortCities portCities) {
  
		
		portCities.setPortId(service.getSequenceNumber(SEQUENCE_NAME));
		PortCities PortCitiesValue=PortCitiesRepo.save(portCities);
		PortCitiesDto PortCitiesDto = new ModelMapper().map(PortCitiesValue, PortCitiesDto.class);

		return PortCitiesDto;
	}

	@Override
	public PortCitiesDto updatePortCities(Integer id,PortCities portCities) {

		PortCitiesDto PortCitiesDto=null;
		Optional<PortCities> PortCitiesData = PortCitiesRepo.findById(id);

		  if (PortCitiesData.isPresent()) {
		    PortCities PortCitiesVal = new PortCities();
		    PortCitiesVal.setPortId(id);
		    PortCitiesVal.setPortCityName(portCities.getPortCityName());
		    PortCitiesVal.setPortType(portCities.getPortType());
		    PortCitiesVal.setCityId(portCities.getCityId());
		    PortCitiesVal.setCountryId(portCities.getCountryId());
		    PortCitiesVal.setStatusId(portCities.isStatusId());
		    
			PortCitiesDto = new ModelMapper().map(PortCitiesRepo.save(portCities), PortCitiesDto.class);

		  }
		  return PortCitiesDto;	}



	@Override
	public void deletePortCities(Integer id) {

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

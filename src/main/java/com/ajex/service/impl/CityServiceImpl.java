package com.ajex.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ajex.dto.CityDto;
import com.ajex.entity.City;
import com.ajex.repository.CityRepo;
import com.ajex.service.CityService;



@Service
public class CityServiceImpl implements CityService {



@Autowired
private CityRepo  cityRepo;


	@Override
	public CityDto addCity(City city) {
  
		
		City cityValue=cityRepo.save(city);
		CityDto cityDto = new ModelMapper().map(cityValue, CityDto.class);

		return cityDto;
	}

	@Override
	public CityDto updateCity(String id,City city) {

		CityDto cityDto=null;
		Optional<City> cityData = cityRepo.findById(id);

		  if (cityData.isPresent()) {
		    City cityVal = new City();
		    cityVal.setCityId(id);
		    cityVal.setCityNameInAr(city.getCityNameInAr());
		    cityVal.setCityCode(city.getCityCode());
		    cityVal.setCountryId(city.getCountryId());
		    cityVal.setRegionId(city.getRegionId());
		    cityVal.setStatusId(city.isStatusId());
		    
		    cityRepo.save(city);
			cityDto = new ModelMapper().map(cityRepo.save(city), CityDto.class);

		  }
		  return cityDto;	}



	@Override
	public void deleteCity(String id) {

		City cityValue= cityRepo.findById(id).get();
		
		if(cityValue!=null)
		{
			cityRepo.delete(cityValue);
			
		}
	}

	@Override
	public List<City> getAllCity() {
		
      List<City> cityValue= cityRepo.findAll();

		
		if(!cityValue.isEmpty())
				
		{
			return cityValue;
		}
		return cityValue;
	}

}

package com.ajex.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ajex.dto.CountryDto;
import com.ajex.entity.Country;
import com.ajex.repository.CountryRepo;
import com.ajex.service.CountryService;



@Service
public class CountryServiceImpl implements CountryService {



@Autowired
private CountryRepo  CountryRepo;


	@Override
	public CountryDto addCountry(Country Country) {
  
		
		Country CountryValue=CountryRepo.save(Country);
		CountryDto CountryDto = new ModelMapper().map(CountryValue, CountryDto.class);

		return CountryDto;
	}

	@Override
	public CountryDto updateCountry(String id,Country Country) {

		CountryDto CountryDto=null;
		Optional<Country> CountryData = CountryRepo.findById(id);

		  if (CountryData.isPresent()) {
		    Country CountryVal = new Country();
		    CountryVal.setCountryId(id);
//		    CountryVal.setCountryNameInAr(Country.getCountryNameInAr());
//		    CountryVal.setCountryCode(Country.getCountryCode());
//		    CountryVal.setCountryId(Country.getCountryId());
//		    CountryVal.setRegionId(Country.getRegionId());
//		    CountryVal.setStatusId(Country.isStatusId());
//		    
		    CountryRepo.save(Country);
			CountryDto = new ModelMapper().map(CountryRepo.save(Country), CountryDto.class);

		  }
		  return CountryDto;	}



	@Override
	public void deleteCountry(String id) {

		Country CountryValue= CountryRepo.findById(id).get();
		
		if(CountryValue!=null)
		{
			CountryRepo.delete(CountryValue);
			
		}
	}

	@Override
	public List<Country> getAllCountries() {
		
      List<Country> CountryValue= CountryRepo.findAll();

		
		if(!CountryValue.isEmpty())
				
		{
			return CountryValue;
		}
		return CountryValue;
	}

}

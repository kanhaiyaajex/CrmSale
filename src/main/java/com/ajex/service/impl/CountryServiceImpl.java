package com.ajex.service.impl;


import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.ajex.entity.Country.*;
import com.ajex.dto.CountryDto;
import com.ajex.entity.Country;
import com.ajex.repository.CountryRepo;
import com.ajex.service.CountryService;



@Service
public class CountryServiceImpl implements CountryService {



@Autowired
private CountryRepo  CountryRepo;


@Autowired
private com.ajex.entity.SequenceGeneratorService service;



	@Override
	public CountryDto addCountry(Country country) {
  
		
		country.setCountryId(service.getSequenceNumber(SEQUENCE_NAME));

		Country CountryValue=CountryRepo.save(country);
		CountryDto CountryDto = new ModelMapper().map(CountryValue, CountryDto.class);

		return CountryDto;
	}

	@Override
	public CountryDto updateCountry(Country country) {

		CountryDto CountryDto=null;
		Optional<Country> CountryData = CountryRepo.findById(country.getCountryId());

		  if (CountryData.isPresent()) {
		    Country CountryVal = new Country();
		    CountryVal.setCountryId(CountryData.get().getCountryId());
		    CountryVal.setCountryName(country.getCountryName());
		    CountryVal.setCountryCode(country.getCountryCode());
		    CountryVal.setCountryId(country.getCountryId());
		    CountryVal.setRefId(country.getRefId());
		    if(country.isStatusId()==true)
		    {
		    	CountryVal.setStatusId(true);
		    }
		    else
		    {
		    	CountryVal.setStatusId(false);
		    }
		    
		    
			CountryDto = new ModelMapper().map(CountryRepo.save(country), CountryDto.class);

		  }
		  return CountryDto;	}



	@Override
	public void deleteCountry(Integer id) {

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

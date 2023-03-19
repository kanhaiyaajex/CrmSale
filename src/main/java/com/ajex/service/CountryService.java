package com.ajex.service;

import java.util.List;

import com.ajex.dto.CityDto;
import com.ajex.dto.CountryDto;
import com.ajex.entity.City;
import com.ajex.entity.Country;

public interface CountryService {
	
	
    public CountryDto addCountry(Country city);
	
	public CountryDto updateCountry(String id,Country city);

	
	public void deleteCountry(String id);
	
	
	public List<Country> getAllCountries();


   

}

package com.ajex.service;

import java.util.List;

import com.ajex.dto.CityDto;
import com.ajex.dto.CountryDto;
import com.ajex.entity.City;
import com.ajex.entity.Country;

public interface CountryService {
	
	
    public CountryDto addCountry(Country country);
	
	public CountryDto updateCountry(Country country);

	
	public void deleteCountry(Integer id);
	
	
	public List<Country> getAllCountries();


   

}

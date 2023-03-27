package com.ajex.service.impl;

import static com.ajex.entity.CityGroup.SEQUENCE_NAME;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ajex.dto.CityDto;
import com.ajex.entity.City;
import com.ajex.entity.Country;
import com.ajex.entity.Region;
import com.ajex.exception.ResourceNotFoundException;
import com.ajex.repository.CityRepo;
import com.ajex.repository.CountryRepo;
import com.ajex.repository.RegionRepo;
import com.ajex.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private com.ajex.entity.SequenceGeneratorService service;

	@Autowired
	private CityRepo cityRepo;
	
	@Autowired
	private RegionRepo regionRepo;
	
	@Autowired
	private CountryRepo countryRepo;

	@Override
	public CityDto addCity(City city) throws ResourceNotFoundException {

		CityDto cityDto = null;
	
			city.setCityId(service.getSequenceNumber(SEQUENCE_NAME));

			Region region= regionRepo.findById(city.getRegionId().getRegionId()).get();
			
//			if(region==null)
//			{
//				
//				throw new ResourceNotFoundException("Region id does not exist " +city.getRegionId());
//			}
			System.out.println("region"+region.getRegionName());

				city.setRegionId(region);
			City citySaved = cityRepo.save(city);
			cityDto = new ModelMapper().map(citySaved, CityDto.class);
			return cityDto;
		
		
	}

	public ResponseEntity<?> updateCity(Integer id, City city) throws ResourceNotFoundException  {
		City cityVal = cityRepo.findById(id).get();

				//.orElseThrow(() ->  ResourceNotFoundException("City not found on :: " + id));

		cityVal.setCityId(id);
		cityVal.setCityNameInAr(city.getCityNameInAr());
		cityVal.setCityCode(city.getCityCode());
		
		Optional<Region> region= regionRepo.findById(city.getRegionId().getRegionId());
		
		
				if(region.isEmpty())
				{
					
					throw new ResourceNotFoundException("Region id does not exist " +city.getRegionId());
				}
				
		cityVal.setRegionId(city.getRegionId());
		cityVal.setStatusId(city.isStatusId());
		CityDto cityDto = new ModelMapper().map(cityRepo.save(cityVal), CityDto.class);
		return new ResponseEntity<>(cityDto, HttpStatus.OK);

	}

	@Override
	public void deleteCity(Integer id) {

		City cityValue = cityRepo.findById(id).get();

		if (cityValue != null) {
			cityRepo.delete(cityValue);

		}
	}

	@Override
	public List<City> getAllCity() {

		List<City> cityValue = cityRepo.findAll();

		if (!cityValue.isEmpty())

		{
			return cityValue;
		}
		return cityValue;
	}

}

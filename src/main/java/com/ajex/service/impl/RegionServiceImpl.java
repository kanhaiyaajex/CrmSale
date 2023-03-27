package com.ajex.service.impl;



import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import static com.ajex.entity.Region.*;



import com.ajex.dto.RegionDto;
import com.ajex.entity.Country;
import com.ajex.entity.Region;
import com.ajex.exception.ResourceNotFoundException;
import com.ajex.repository.CountryRepo;
import com.ajex.repository.RegionRepo;
import com.ajex.service.RegionService;



@Service
public class RegionServiceImpl implements RegionService {



@Autowired
private RegionRepo  RegionRepo;



@Autowired
private CountryRepo  countryRepo;


@Autowired
private com.ajex.entity.SequenceGeneratorService service;



	@Override
	public RegionDto addRegion(Region region) throws ResourceNotFoundException {
  
		
		Optional<Country> country= countryRepo.findById(region.getCountryId().getCountryId());
		
		if(country.isEmpty())
		{
			
			throw new ResourceNotFoundException("Country id does not exist " +region.getCountryId());
		}
		region.setRegionId(service.getSequenceNumber(SEQUENCE_NAME));
		Region RegionValue=RegionRepo.save(region);
		RegionDto RegionDto = new ModelMapper().map(RegionValue, RegionDto.class);

		return RegionDto;
	}

	@Override
	public RegionDto updateRegion(Region region) throws ResourceNotFoundException {

		RegionDto RegionDto=null;
		Optional<Region> RegionData = RegionRepo.findById(region.getRegionId());

		  if (RegionData.isPresent()) {
		    Region RegionVal = new Region();
		    RegionVal.setRegionId(region.getRegionId());
		    Optional<Country> country= countryRepo.findById(region.getCountryId().getCountryId());
			
			if(country.isEmpty())
			{
				
				throw new ResourceNotFoundException("Country id does not exist " +region.getCountryId());
			}
		    RegionVal.setCountryId(region.getCountryId());
		    RegionVal.setRefId(region.getRefId());
		    RegionVal.setRegionName(region.getRegionName());
		    
		    RegionRepo.save(region);
			RegionDto = new ModelMapper().map(RegionRepo.save(region), RegionDto.class);

		  }
		  return RegionDto;	}



	@Override
	public void deleteRegion(Integer id) {

		Region RegionValue= RegionRepo.findById(id).get();
		
		if(RegionValue!=null)
		{
			RegionRepo.delete(RegionValue);
			
		}
	}

	@Override
	public List<Region> getAllRegion() {
		
      List<Region> RegionValue= RegionRepo.findAll();

		
			return RegionValue;
		
	}

}

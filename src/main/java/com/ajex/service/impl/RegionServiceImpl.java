package com.ajex.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ajex.dto.RegionDto;
import com.ajex.entity.Region;
import com.ajex.repository.RegionRepo;
import com.ajex.service.RegionService;



@Service
public class RegionServiceImpl implements RegionService {



@Autowired
private RegionRepo  RegionRepo;


	@Override
	public RegionDto addRegion(Region Region) {
  
		
		Region RegionValue=RegionRepo.save(Region);
		RegionDto RegionDto = new ModelMapper().map(RegionValue, RegionDto.class);

		return RegionDto;
	}

	@Override
	public RegionDto updateRegion(String id,Region Region) {

		RegionDto RegionDto=null;
		Optional<Region> RegionData = RegionRepo.findById(id);

		  if (RegionData.isPresent()) {
		    Region RegionVal = new Region();
		    RegionVal.setRegionId(id);
//		    RegionVal.setRegionNameInAr(Region.getRegionNameInAr());
//		    RegionVal.setRegionCode(Region.getRegionCode());
//		    RegionVal.setCountryId(Region.getCountryId());
//		    RegionVal.setRegionId(Region.getRegionId());
//		    RegionVal.setStatusId(Region.isStatusId());
//		    
		    RegionRepo.save(Region);
			RegionDto = new ModelMapper().map(RegionRepo.save(Region), RegionDto.class);

		  }
		  return RegionDto;	}



	@Override
	public void deleteRegion(String id) {

		Region RegionValue= RegionRepo.findById(id).get();
		
		if(RegionValue!=null)
		{
			RegionRepo.delete(RegionValue);
			
		}
	}

	@Override
	public List<Region> getAllRegion() {
		
      List<Region> RegionValue= RegionRepo.findAll();

		
		if(!RegionValue.isEmpty())
				
		{
			return RegionValue;
		}
		return RegionValue;
	}

}

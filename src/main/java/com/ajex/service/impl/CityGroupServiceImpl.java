package com.ajex.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ajex.dto.CityGroupDto;
import com.ajex.entity.CityGroup;
import com.ajex.repository.CityGroupRepo;
import com.ajex.service.CityGroupService;



@Service
public class CityGroupServiceImpl implements CityGroupService {



@Autowired
private CityGroupRepo  CityGroupRepo;


	@Override
	public CityGroupDto addCityGroup(CityGroup CityGroup) {
  
		
		CityGroup CityGroupValue=CityGroupRepo.save(CityGroup);
		CityGroupDto CityGroupDto = new ModelMapper().map(CityGroupValue, CityGroupDto.class);

		return CityGroupDto;
	}

	@Override
	public CityGroupDto updateCityGroup(String id,CityGroup cityGroup) {

		CityGroupDto CityGroupDto=null;
		Optional<CityGroup> CityGroupData = CityGroupRepo.findById(id);

		  if (CityGroupData.isPresent()) {
		    CityGroup CityGroupVal = new CityGroup();
		    CityGroupVal.setCityGroupId(id);
//		    CityGroupVal.setCityGroupNameInAr(CityGroup.getCityGroupNameInAr());
//		    CityGroupVal.setCityGroupCode(CityGroup.getCityGroupCode());
//		    CityGroupVal.setCountryId(CityGroup.getCountryId());
//		    CityGroupVal.setRegionId(CityGroup.getRegionId());
//		    CityGroupVal.setStatusId(CityGroup.isStatusId());
		    
		    CityGroupRepo.save(cityGroup);
			CityGroupDto = new ModelMapper().map(CityGroupRepo.save(cityGroup), CityGroupDto.class);

		  }
		  return CityGroupDto;	}



	@Override
	public void deleteCityGroup(String id) {

		CityGroup CityGroupValue= CityGroupRepo.findById(id).get();
		
		if(CityGroupValue!=null)
		{
			CityGroupRepo.delete(CityGroupValue);
			
		}
	}

	@Override
	public List<CityGroup> getAllCityGroup() {
		
      List<CityGroup> CityGroupValue= CityGroupRepo.findAll();

		
		if(!CityGroupValue.isEmpty())
				
		{
			return CityGroupValue;
		}
		return CityGroupValue;
	}

}

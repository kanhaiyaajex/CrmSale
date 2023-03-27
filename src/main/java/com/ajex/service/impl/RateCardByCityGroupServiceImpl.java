package com.ajex.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.ajex.entity.RateCardByCityGroup.*;


import com.ajex.dto.CityDto;
import com.ajex.dto.RateCardByCityGroupDto;
import com.ajex.entity.City;
import com.ajex.entity.CityGroup;
import com.ajex.entity.RateCardByCityGroup;


@Service
public class RateCardByCityGroupServiceImpl implements com.ajex.service.RateCardByCityGroupService {

	@Autowired
	private ModelMapper modelMapper;
	
	
	@Autowired
	private com.ajex.entity.SequenceGeneratorService service;

	@Autowired
	private com.ajex.repository.RateCardByCityGroupRepo RateCardByCityGroupRepo;

	@Override
	public RateCardByCityGroupDto addRateCardByCityGroup(RateCardByCityGroup RateCardByCityGroup) {

		RateCardByCityGroup.setRateCardByCityGroupId(service.getSequenceNumber(SEQUENCE_NAME));
		RateCardByCityGroup RateCardByCityGroupValue = RateCardByCityGroupRepo.save(RateCardByCityGroup);
		RateCardByCityGroupDto RateCardByCityGroupDto = new ModelMapper().map(RateCardByCityGroupValue, RateCardByCityGroupDto.class);

		return RateCardByCityGroupDto;
	}

	@Override
	public ResponseEntity<?> updateRateCardByCityGroup(Integer id, RateCardByCityGroup RateCardByCityGroup)  {


		RateCardByCityGroup RateCardByCityGroupVal = RateCardByCityGroupRepo.findById(id).get();

				//.orElseThrow(() -> new ResourceNotFoundException("RateCardByCityGroup not found on :: " + id));

		RateCardByCityGroupVal.setRateCardByCityGroupId(id);
		RateCardByCityGroupVal.setDestinationGroupId(RateCardByCityGroup.getDestinationGroupId());
		RateCardByCityGroupVal.setGroupName(RateCardByCityGroup.getGroupName());
		RateCardByCityGroupVal.setGroupOrderId(RateCardByCityGroup.getGroupOrderId());
		RateCardByCityGroupVal.setOriginGroupId(RateCardByCityGroup.getOriginGroupId());

		RateCardByCityGroupVal.setStatusId(RateCardByCityGroup.isStatusId());


		RateCardByCityGroupDto RateCardByCityGroupDto = new ModelMapper().map(RateCardByCityGroupRepo.save(RateCardByCityGroupVal), RateCardByCityGroupDto.class);
		return new ResponseEntity<>(RateCardByCityGroupDto, HttpStatus.OK);

	}

	@Override
	public void deleteRateCardByCityGroup(Integer id) {

		RateCardByCityGroup RateCardByCityGroupValue = RateCardByCityGroupRepo.findById(id).get();

		if (RateCardByCityGroupValue != null) {
			RateCardByCityGroupRepo.delete(RateCardByCityGroupValue);

		}
	}

	@Override
	public List<RateCardByCityGroup> getAllRateCardByCityGroup() {
		
		List<RateCardByCityGroup> RateCardByCityGroupValue = RateCardByCityGroupRepo.findAll();
		
		
		
		return RateCardByCityGroupValue;
	}


}

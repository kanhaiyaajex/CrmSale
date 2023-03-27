package com.ajex.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.ajex.entity.CityGroup.*;

import com.ajex.dto.CityDto;
import com.ajex.dto.CityGroupDto;
import com.ajex.entity.City;
import com.ajex.entity.CityGroup;
import com.ajex.repository.CityGroupRepo;
import com.ajex.service.CityGroupService;

@Service
public class CityGroupServiceImpl implements CityGroupService {

	@Autowired
	private com.ajex.entity.SequenceGeneratorService service;

	@Autowired
	private CityGroupRepo CityGroupRepo;

	@Autowired
	private com.ajex.repository.DivisionRepo DivisionRepo;

	@Override
	public CityGroupDto addCityGroup(CityGroup cityGroup) {

		cityGroup.setCityGroupId(service.getSequenceNumber(SEQUENCE_NAME));
		
		
		
		CityGroup CityGroupValue = CityGroupRepo.save(cityGroup);
		CityGroupDto CityGroupDto = new ModelMapper().map(CityGroupValue, CityGroupDto.class);

		return CityGroupDto;
	}

	@Override
	public ResponseEntity<?> updateCityGroup(Integer id, CityGroup cityGroup) {

		CityGroup CityGroupVal = CityGroupRepo.findById(id).get();

		// .orElseThrow(() -> new ResourceNotFoundException("CityGroup not found on :: "
		// + id));

		CityGroupVal.setCityGroupId(id);
		CityGroupVal.setGroupName(cityGroup.getGroupName());
		CityGroupVal.setGroupOrderId(cityGroup.getGroupOrderId());
		CityGroupVal.setStatusId(cityGroup.isStatusId());

		CityGroupDto cityGroupDto = new ModelMapper().map(CityGroupRepo.save(CityGroupVal), CityGroupDto.class);
		return new ResponseEntity<>(cityGroupDto, HttpStatus.OK);

	}

	@Override
	public void deleteCityGroup(Integer id) {

		CityGroup CityGroupValue = CityGroupRepo.findById(id).get();

		if (CityGroupValue != null) {
			CityGroupRepo.delete(CityGroupValue);

		}
	}

	@Override
	public List<CityGroup> getAllCityGroup() {

		List<CityGroup> CityGroupValue = CityGroupRepo.findAll();

		return CityGroupValue;

	}

}

package com.ajex.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.ajex.entity.MeasureOfUnit.*;


import com.ajex.dto.CityDto;
import com.ajex.dto.MeasureOfUnitDto;
import com.ajex.entity.City;
import com.ajex.entity.MeasureOfUnit;
import com.ajex.repository.MeasureOfUnitRepo;
import com.ajex.service.MeasureOfUnitService;

@Service
public class MeasureOfUnitServiceImpl implements MeasureOfUnitService {

	@Autowired
	private com.ajex.entity.SequenceGeneratorService service;

	@Autowired
	private MeasureOfUnitRepo MeasureOfUnitRepo;

	@Override
	public MeasureOfUnitDto addMeasureOfUnit(MeasureOfUnit MeasureOfUnit) {

		MeasureOfUnit.setMeasureOfUnitId(service.getSequenceNumber(SEQUENCE_NAME));
		MeasureOfUnit MeasureOfUnitValue = MeasureOfUnitRepo.save(MeasureOfUnit);
		MeasureOfUnitDto MeasureOfUnitDto = new ModelMapper().map(MeasureOfUnitValue, MeasureOfUnitDto.class);

		return MeasureOfUnitDto;
	}

	@Override
	public ResponseEntity<?> updateMeasureOfUnit(Integer id, MeasureOfUnit MeasureOfUnit)  {


		MeasureOfUnit MeasureOfUnitVal = MeasureOfUnitRepo.findById(id).get();

				//.orElseThrow(() -> new ResourceNotFoundException("MeasureOfUnit not found on :: " + id));

		MeasureOfUnitVal.setMeasureOfUnitId(id);
		MeasureOfUnitVal.setUnitName(MeasureOfUnit.getUnitName());
		//MeasureOfUnitVal.setGroupOrderId(MeasureOfUnit.getGroupOrderId();
		MeasureOfUnitVal.setStatusId(MeasureOfUnit.isStatusId());

		MeasureOfUnitDto MeasureOfUnitDto = new ModelMapper().map(MeasureOfUnitRepo.save(MeasureOfUnitVal), MeasureOfUnitDto.class);
		return new ResponseEntity<>(MeasureOfUnitDto, HttpStatus.OK);

	}

	@Override
	public void deleteMeasureOfUnit(Integer id) {

		MeasureOfUnit MeasureOfUnitValue = MeasureOfUnitRepo.findById(id).get();

		if (MeasureOfUnitValue != null) {
			MeasureOfUnitRepo.delete(MeasureOfUnitValue);

		}
	}

	@Override
	public List<MeasureOfUnit> getAllMeasureOfUnit() {

		List<MeasureOfUnit> MeasureOfUnitValue = MeasureOfUnitRepo.findAll();

	
			return MeasureOfUnitValue;
		
	}

	}

package com.ajex.service.impl;

import static com.ajex.entity.AdditionalService.SEQUENCE_NAME;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ajex.dto.AdditionalServiceDto;
import com.ajex.entity.AdditionalService;
import com.ajex.entity.Category;
import com.ajex.exception.ResourceNotFoundException;
import com.ajex.repository.CategoryRepo;
import com.ajex.repository.DivisionRepo;


@Service
public class AdditionalServiceImpl implements com.ajex.service.AdditionalServices {

	@Autowired
	private ModelMapper modelMapper;
	
	
	@Autowired
	private com.ajex.entity.SequenceGeneratorService service;

	@Autowired
	private com.ajex.repository.AdditionalServiceRepo AdditionalServiceRepo;
	
	

	@Autowired
	private CategoryRepo categoryRepo;
	
	

	@Autowired
	private DivisionRepo divisionRepo;
	

	@Override
	public AdditionalServiceDto addAdditionalService(AdditionalService AdditionalService) {

		AdditionalService.setAdditionalServiceId(service.getSequenceNumber(SEQUENCE_NAME));
		
		//Optional<Category> CategoryVal = CategoryRepo.findById(AdditionalService.getCategoryId());

		
		
		AdditionalService AdditionalServiceValue = AdditionalServiceRepo.save(AdditionalService);
		AdditionalServiceDto AdditionalServiceDto = new ModelMapper().map(AdditionalServiceValue, AdditionalServiceDto.class);

		return AdditionalServiceDto;
	}

	@Override
	public ResponseEntity<?> updateAdditionalService(Integer id, AdditionalService AdditionalService)  {


		AdditionalService AdditionalServiceVal = AdditionalServiceRepo.findById(id).get();

				//.orElseThrow(() -> new ResourceNotFoundException("AdditionalService not found on :: " + id));

		AdditionalServiceVal.setAdditionalServiceId(id);
		AdditionalServiceVal.setCategoryId(AdditionalService.getCategoryId());
		AdditionalServiceVal.setDivisionId(AdditionalService.getDivisionId());
		AdditionalServiceVal.setStatusId(AdditionalService.isStatusId());

		AdditionalServiceDto AdditionalServiceDto = new ModelMapper().map(AdditionalServiceRepo.save(AdditionalServiceVal), AdditionalServiceDto.class);
		return new ResponseEntity<>(AdditionalServiceDto, HttpStatus.OK);

	}

	@Override
	public void deleteAdditionalService(Integer id) {

		AdditionalService AdditionalServiceValue = AdditionalServiceRepo.findById(id).get();

		if (AdditionalServiceValue != null) {
			AdditionalServiceRepo.delete(AdditionalServiceValue);

		}
	}

	@Override
	public List<AdditionalService> getAllAdditionalService() {
		
		List<AdditionalService> AdditionalServiceValue = AdditionalServiceRepo.findAll();
		
		
		
		return AdditionalServiceValue;
	}


}

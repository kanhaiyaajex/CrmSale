package com.ajex.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ajex.dto.PositionDto;
import com.ajex.entity.Position;
import com.ajex.repository.PositionRepo;
import com.ajex.service.PositionService;



@Service
public class PositionServiceImpl implements PositionService {



@Autowired
private PositionRepo  PositionRepo;


	@Override
	public PositionDto addPosition(Position Position) {
  
		
		Position PositionValue=PositionRepo.save(Position);
		PositionDto PositionDto = new ModelMapper().map(PositionValue, PositionDto.class);

		return PositionDto;
	}

	@Override
	public PositionDto updatePosition(String id,Position Position) {

		PositionDto PositionDto=null;
		Optional<Position> PositionData = PositionRepo.findById(id);

		  if (PositionData.isPresent()) {
		    Position PositionVal = new Position();
		    PositionVal.setPositionId(id);
//		    PositionVal.setPositionNameInAr(Position.getPositionNameInAr());
//		    PositionVal.setPositionCode(Position.getPositionCode());
//		    PositionVal.setCountryId(Position.getCountryId());
//		    PositionVal.setRegionId(Position.getRegionId());
//		    PositionVal.setStatusId(Position.isStatusId());
		    
		    PositionRepo.save(Position);
			PositionDto = new ModelMapper().map(PositionRepo.save(Position), PositionDto.class);

		  }
		  return PositionDto;	}



	@Override
	public void deletePosition(String id) {

		Position PositionValue= PositionRepo.findById(id).get();
		
		if(PositionValue!=null)
		{
			PositionRepo.delete(PositionValue);
			
		}
	}

	@Override
	public List<Position> getAllPosition() {
		
      List<Position> PositionValue= PositionRepo.findAll();

		
		if(!PositionValue.isEmpty())
				
		{
			return PositionValue;
		}
		return PositionValue;
	}

}

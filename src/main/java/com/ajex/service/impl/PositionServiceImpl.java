package com.ajex.service.impl;

import java.util.List;
import java.util.Optional;

import static com.ajex.entity.Position.*;



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
private com.ajex.entity.SequenceGeneratorService service;

@Autowired
private PositionRepo  PositionRepo;


	@Override
	public PositionDto addPosition(Position position) {
  
		
		position.setPositionId(service.getSequenceNumber(SEQUENCE_NAME));
		Position PositionValue=PositionRepo.save(position);
		PositionDto PositionDto = new ModelMapper().map(PositionValue, PositionDto.class);

		return PositionDto;
	}

	@Override
	public PositionDto updatePosition(Integer id,Position position) {

		PositionDto PositionDto=null;
		Optional<Position> PositionData = PositionRepo.findById(id);

		  if (PositionData.isPresent()) {
		    Position PositionVal = new Position();
		    PositionVal.setPositionId(id);
		    PositionVal.setPositionName(position.getPositionName());
		    PositionVal.setOrderId(position.getOrderId());
		    
		    PositionVal.setStatusId(position.isStatusId());
		    
			PositionDto = new ModelMapper().map(PositionRepo.save(position), PositionDto.class);

		  }
		  return PositionDto;	}



	@Override
	public void deletePosition(Integer id) {

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

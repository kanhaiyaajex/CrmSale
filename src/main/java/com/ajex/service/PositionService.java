package com.ajex.service;

import java.util.List;

import com.ajex.dto.PositionDto;
import com.ajex.entity.Position;

public interface PositionService {
	
	public PositionDto addPosition(Position Position);
	
	public PositionDto updatePosition(Integer id,Position Position);

	
	public void deletePosition(Integer id);
	
	
	public List<Position> getAllPosition();

     	

	


}
